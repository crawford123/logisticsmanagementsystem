package com.paul.logisticsmanagementsystem.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertySetStrategy;
import net.sf.json.xml.XMLSerializer;
import org.apache.http.protocol.HTTP;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.*;

public class JsonUtils {
	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param beanCalss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
		return bean;

	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param beanCalss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss, Map<String, Class> classMap) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JsonConfig cfg = new JsonConfig();
		cfg.setPropertySetStrategy(new PropertyStrategyWrapper(PropertySetStrategy.DEFAULT));
		cfg.setRootClass(beanCalss);
		cfg.setClassMap(classMap);
		T bean = (T) JSONObject.toBean(jsonObject, cfg);
		return bean;

	}

	/**
	 * 将java对象转换成json字符串
	 *
	 * @param bean
	 * @return
	 */
	public static String beanToJson(Object bean) {
		JSONObject json = JSONObject.fromObject(bean);
		return json.toString();

	}

	/**
	 * 将java对象转换成json字符串
	 *
	 * @param bean
	 * @return
	 */
	public static String beanToJson(Object bean, String[] _nory_changes, boolean nory) {

		JSONObject json = null;

		if (nory) {// 转换_nory_changes里的属性

			Field[] fields = bean.getClass().getDeclaredFields();
			String str = "";
			for (Field field : fields) {
				// System.out.println(field.getName());
				str += (":" + field.getName());
			}
			fields = bean.getClass().getSuperclass().getDeclaredFields();
			for (Field field : fields) {
				// System.out.println(field.getName());
				str += (":" + field.getName());
			}
			str += ":";
			for (String s : _nory_changes) {
				str = str.replace(":" + s + ":", ":");
			}
			json = JSONObject.fromObject(bean, configJson(str.split(":")));

		} else {// 转换除了_nory_changes里的属性

			json = JSONObject.fromObject(bean, configJson(_nory_changes));
		}

		return json.toString();

	}

	private static JsonConfig configJson(String[] excludes) {

		JsonConfig jsonConfig = new JsonConfig();

		jsonConfig.setExcludes(excludes);
		//
		jsonConfig.setIgnoreDefaultExcludes(false);
		//
		// jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

		// jsonConfig.registerJsonValueProcessor(Date.class,
		//
		// new DateJsonValueProcessor(datePattern));

		return jsonConfig;

	}

	/**
	 * 将java对象List集合转换成json字符串
	 * 
	 * @param beans
	 * @return
	 */
	public static String beanListToJson(List<?> beans) {

		StringBuffer rest = new StringBuffer();

		rest.append("[");

		int size = beans.size();

		for (int i = 0; i < size; i++) {

			rest.append(beanToJson(beans.get(i)) + ((i < size - 1) ? "," : ""));

		}

		rest.append("]");

		return rest.toString();

	}

	/**
	 * 
	 * @param beans
	 * @param _no_changes
	 * @return
	 */
	public static String beanListToJson(List<?> beans, String[] _nory_changes, boolean nory) {

		StringBuffer rest = new StringBuffer();

		rest.append("[");

		int size = beans.size();

		for (int i = 0; i < size; i++) {
			try {
				rest.append(beanToJson(beans.get(i), _nory_changes, nory));
				if (i < size - 1) {
					rest.append(",");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		rest.append("]");

		return rest.toString();

	}

	/**
	 * 从json HASH表达式中获取一个map，改map支持嵌套功能
	 *
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(String jsonString) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Iterator<String> keyIter = jsonObject.keys();
		String key;
		Object value;
		Map<String, Object> valueMap = new HashMap<String, Object>();
		while (keyIter.hasNext()) {
			key = keyIter.next();
			value = jsonObject.get(key);
			if (value instanceof JSONArray) {
				JSONArray list = (JSONArray) value;
				List<Map<String, Object>> hs =valueMap.get("list")!=null? (ArrayList<Map<String, Object>>) valueMap.get("list"):new ArrayList<Map<String, Object>>();
				for (int i = 0; i < list.size(); i++) {
					JSONObject object = list.getJSONObject(i);
					Iterator<String> keys = object.keys();
					Map<String, Object> m=new HashMap<String, Object>();
					while (keys.hasNext()) {
						String child = keys.next();
						Object childValue = object.get(child);
						m.put(child, childValue);
					}
					hs.add(m);
				}
				valueMap.put("list",hs);
			}else{
				valueMap.put(key, value.toString());
			}
		}
		return valueMap;
	}

	public static String mapToJson(Map<String, Object> map) {
		return JSONObject.fromObject(map).toString();
	}

	/**
	 * map集合转换成json格式数据
	 * 
	 * @param map
	 * @return
	 */
	public static String mapToJson(Map<String, Object> map, String[] _nory_changes, boolean nory) {
		String s_json = "{";
		Set<String> key = map.keySet();
		for (Iterator<?> it = key.iterator(); it.hasNext();) {
			String s = (String) it.next();
			if (map.get(s) == null) {
			} else if (map.get(s) instanceof List<?>) {
				s_json += (s + ":" + beanListToJson((List<?>) map.get(s), _nory_changes, nory));
			} else {
				JSONObject json = JSONObject.fromObject(map);
				s_json += (s + ":" + json.toString());
			}
			if (it.hasNext()) {
				s_json += ",";
			}
		}

		s_json += "}";
		return s_json;
	}

	/**
	 * 从json数组中得到相应java数组
	 *
	 * @param jsonString
	 * @return
	 */
	public static Object[] jsonToObjectArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);

		return jsonArray.toArray();

	}

	public static String listToJson(List<?> list) {

		JSONArray jsonArray = JSONArray.fromObject(list);

		return jsonArray.toString();

	}

	/**
	 * 从json对象集合表达式中得到一个java对象列表
	 *
	 * @param jsonString
	 * @param beanClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToBeanList(String jsonString, Class<T> beanClass) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		T bean;
		int size = jsonArray.size();
		List<T> list = new ArrayList<T>(size);

		for (int i = 0; i < size; i++) {

			jsonObject = jsonArray.getJSONObject(i);
			bean = (T) JSONObject.toBean(jsonObject, beanClass);
			list.add(bean);

		}

		return list;

	}

	/**
	 * 从json数组中解析出java字符串数组
	 *
	 * @param jsonString
	 * @return
	 */
	public static String[] jsonToStringArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		String[] stringArray = new String[jsonArray.size()];
		int size = jsonArray.size();

		for (int i = 0; i < size; i++) {

			stringArray[i] = jsonArray.getString(i);

		}

		return stringArray;
	}

	/**
	 * 从json数组中解析出javaLong型对象数组
	 *
	 * @param jsonString
	 * @return
	 */
	public static Long[] jsonToLongArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		int size = jsonArray.size();
		Long[] longArray = new Long[size];

		for (int i = 0; i < size; i++) {

			longArray[i] = jsonArray.getLong(i);

		}

		return longArray;

	}

	/**
	 * 从json数组中解析出java Integer型对象数组
	 *
	 * @param jsonString
	 * @return
	 */
	public static Integer[] jsonToIntegerArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		int size = jsonArray.size();
		Integer[] integerArray = new Integer[size];

		for (int i = 0; i < size; i++) {

			integerArray[i] = jsonArray.getInt(i);

		}

		return integerArray;

	}

	/**
	 * 从json数组中解析出java Double型对象数组
	 *
	 * @param jsonString
	 * @return
	 */
	public static Double[] jsonToDoubleArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		int size = jsonArray.size();
		Double[] doubleArray = new Double[size];

		for (int i = 0; i < size; i++) {
			doubleArray[i] = jsonArray.getDouble(i);
		}

		return doubleArray;

	}

	/**
	 * XML转为Json
	 *
	 * @param jsonString
	 * @return
	 */
	public static String xml2Json(String xml) {
		return new XMLSerializer().read(xml).toString();
	}

	/**
	 * Json转为XML
	 *
	 * @param jsonString
	 * @return
	 */
	public static String json2XML(String json) {
		JSONObject jobj = JSONObject.fromObject(json);
		String xml = new XMLSerializer().write(jobj);
		return xml;
	}

	/**
	 * httpClient 通过post方式传递后，不使用key直接取出json字符串参数
	 * @param httpServletRequest
	 * @return
	 */
	public static String getJsonFromHttpRequest(HttpServletRequest httpServletRequest) {
		String jsonStr = "";
		try {
			// 参数获取方式是kv对，通过k来获取，但是这里的post方法没有k
			// 用流的方式来获取json参数
			BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			// 将资料解码
			jsonStr = sb.toString();
			jsonStr = URLDecoder.decode(jsonStr, HTTP.UTF_8);
			return jsonStr;
		} catch (UnsupportedEncodingException e) {
			LogCvt.error(e.getMessage(), e);
		} catch (IOException e) {
			LogCvt.error(e.getMessage(), e);
		}
		return jsonStr;
	}
}
