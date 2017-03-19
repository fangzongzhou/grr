package com.fzz;

import com.fzz.util.PathUtil;
import com.fzz.util.RegularExpUtil;
import com.fzz.util.UrlUtil;
import com.fzz.util.baidu.TransApi;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuyoo on 2017/3/16.
 */
public class Test {


    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
//    private static final String APP_ID = "20170317000042495";
//    private static final String SECURITY_KEY = "etrSqzDxbVjXD5ebNKWZ";
//
//    public static void main(String[] args) {
//        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
//
//        String query = "高度600米";
//        System.out.println(api.getTransResult(query, "auto", "en"));
//    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url=new URL("https://kyfw.12306.cn/otn/resources/js/framework/station_name.js");
        System.out.println(url.getFile());
        System.out.println(url.toURI());
        System.out.println(url.getUserInfo());
        System.out.println(url.getRef());
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        JsonArray jsonArray=new JsonArray();



    }

}

