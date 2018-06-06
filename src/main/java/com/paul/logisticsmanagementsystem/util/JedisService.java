package com.paul.logisticsmanagementsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class JedisService {
    static Logger logger = LoggerFactory.getLogger(JedisService.class);
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private JedisConnectionFactory factory;

    public Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    public void closeRedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    public void setIntoRedis(String key, Object obj, Integer timeout) {
        Jedis jedis = getJedis();
        logger.info("------------------jedis:" + jedis);
        jedis.set(key.getBytes(), SerializationUtils.serialize(obj));
        if (timeout != null) {
            jedis.expire(key, timeout);
        }
        closeRedis(jedis);
    }

    public void setIntoRedis(String key, Object obj) {
        setIntoRedis(key, obj, null);
    }

    public void delFromRedis(String key) {
        Jedis jedis = getJedis();
        jedis.del(key);
        closeRedis(jedis);
    }

    public Object getFromRedis(String key) {
        Jedis jedis = getJedis();
        byte[] data = jedis.get(key.getBytes());
        closeRedis(jedis);
        return SerializationUtils.deserialize(data);
    }

    public <T> T getTFromRedis(Class clz, String key) {
        Jedis jedis = getJedis();
        byte[] data = jedis.get(key.getBytes());
        closeRedis(jedis);
        return deserialize2(clz, data);
    }

    public byte[] getByteArrayFromRedis(String key) {
        Jedis jedis = getJedis();
        byte[] data = jedis.get(key.getBytes());
        closeRedis(jedis);
        return data;
    }

    public Long getSequenceNumber(String key, Integer timeout) {
        Jedis jedis = getJedis();
        Long no = jedis.incr(key);
        if (timeout != null) {
            jedis.expire(key, timeout);
        }
        closeRedis(jedis);
        return no;
    }

//    public List<FmMgrOptionVo> getdicsFromRedis(String optionType) {
//        String key = "dic:" + optionType.toLowerCase().replace("_", "") + "List";
//        byte[] data = getByteArrayFromRedis(key);
//        return deserialize(data);
//    }
//
//    /**
//     * 字节数组转换成原始字典list
//     *
//     * @param in
//     * @return
//     * @Title: deserialize
//     */
//    public static List<FmMgrOptionVo> deserialize(byte[] in) {
//        List<FmMgrOptionVo> list = new ArrayList<>();
//        ByteArrayInputStream bis = null;
//        ObjectInputStream is = null;
//        try {
//            if (in != null) {
//                bis = new ByteArrayInputStream(in);
//                is = new ObjectInputStream(bis);
//                while (true) {
//                    list = (List<FmMgrOptionVo>) is.readObject();
//                    break;
//                }
//                is.close();
//                bis.close();
//            }
//        } catch (IOException e) {
//            logger.error(String.format("Caught IOException decoding %d bytes of data", in == null ? 0 : in.length) + e);
//        } catch (ClassNotFoundException e) {
//            logger.error(String.format("Caught CNFE decoding %d bytes of data", in == null ? 0 : in.length) + e);
//        } finally {
//        }
//        return list;
//    }

    public static <T> T deserialize2(Class clz, byte[] in) {
        // FmMgrUserVo vo = new FmMgrUserVo();
        T t = null;
        try {
            t = (T) clz.newInstance();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    t = (T) is.readObject();
                    break;
                }
                is.close();
                bis.close();
            }
        } catch (IOException e) {
            logger.error(String.format("Caught IOException decoding %d bytes of data", in == null ? 0 : in.length) + e);
        } catch (ClassNotFoundException e) {
            logger.error(String.format("Caught CNFE decoding %d bytes of data", in == null ? 0 : in.length) + e);
        } finally {
        }
        return t;
    }

    public Set<String> getAllKeys(String pattern) {
        Jedis jedis = getJedis();
        Set<String> keys = jedis.keys(pattern);
        closeRedis(jedis);
        return keys;
    }
}
