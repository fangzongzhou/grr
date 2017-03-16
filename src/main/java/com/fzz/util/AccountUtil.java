package com.fzz.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by fzz on 2017/2/24.
 * I have For  account to encrypt
 * every password pass this web should use it
 * login and registered
 * 账号管理工具
 */
public class AccountUtil {

    public static String to48PassChar(String string) {
        String num_A="0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T U V";
        char[] feedArray = num_A.replace(" ","").toCharArray();
        MessageDigest messageDigest = null;
        String md5str = null;
        String result=null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            md5str = base64Encoder.encode(messageDigest.digest(string.getBytes("utf-8")));
            byte[] bytes=md5str.getBytes();
            char[] out = new char[24 * 2];
            for (int i = 0, j = 0; i < 24; i++) {
                out[j++] = feedArray[bytes[i] >>> 2 & 0x1f];
                out[j++] = feedArray[bytes[i] & 0x1f];
            }
            result=new String(out);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;

    }
}
