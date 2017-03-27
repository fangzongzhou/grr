package com.fzz;

import com.fzz.util.PathUtil;
import com.fzz.util.RegularExpUtil;
import com.fzz.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuyoo on 2017/3/16.
 */
public class Test {
    public static void main(String[] args) {


//        RegularExpUtil regularExpUtil=new RegularExpUtil();
//        UrlUtil urlUtil=new UrlUtil();
//        String result;
//        //result = urlUtil.get_Response_Str("http://www.cnblogs.com/gaopeng527/p/4523740.html");
//        String str = "service@xsoftlab.net";
//        // 邮箱验证规则
//        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
//        // 编译正则表达式
//        List<String> res = regularExpUtil.getMatchingResult(str,regEx);
//        Iterator<String> iterator=res.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println(regularExpUtil.is_matching(str,regEx));
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("connection to server successful");
//        System.out.println("server is runing: "+jedis.ping());
//        jedis.set("fzzname", "fangzongzhou");
//        System.out.println("result::  "+jedis.get("fzzname"));
        UrlUtil urlUtil=new UrlUtil();
        String asd="http://125.39.220.71:9100/20170324/20/";
        //System.out.println(urlUtil.get_Response_Str("http://125.39.220.71:9100/20170324/21/55_40_ERRORS_17_9101.html"));
        String[] ss = urlUtil.get_Response_Str(asd).split("href=\"");
        int i=0;
        for (String s:ss
             ) {
            String rs=s.substring(0,s.indexOf("\""));
           // System.out.println(s.substring(0,s.indexOf("\"")));
            System.out.println(i++);
            System.out.println(urlUtil.get_Response_Str(asd+rs));
        }

    }
}
