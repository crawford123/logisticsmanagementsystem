package com.paul.logisticsmanagementsystem.util;

import java.security.MessageDigest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 5/11/2018
 * Time: 3:30 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class MD5Util {

    /*一次加密，两次解密*/
    /**
     * Title: MD5加密 生成32位md5码
     * Description: TestDemo
     * @author FengZhi
     * @date 2018年5月11日 下午3:34:07
     * @param inStr
     * @return 返回32位md5码
     * @throws Exception
     */
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


           /* 不返回返回32位md5码*/
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
    /*进行两次解密*/
    public static String md5Decode(String str) {
        return convertMD5(convertMD5(str));
    }

     public static  void main(String[] args){
            String encode="77c9ee67dc842b6ec647d21df04703c9";
            String decode=MD5Util.md5Decode(encode);
            System.out.println("解密后的密码为：");

     }


}
