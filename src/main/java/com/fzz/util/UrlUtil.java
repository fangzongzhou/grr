package com.fzz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by tuyoo on 2017/3/16.
 */

public class UrlUtil {

    /*传入接口url字符串，返回响应的字符串
    *
    *
    *
    * */
    public String get_Response_Str(String url_str) {

        BufferedReader in = null;
        StringBuilder response_str = new StringBuilder();
        try {
            URL url = new URL(url_str);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null)
            {
                System.out.println(str);
                response_str.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response_str.toString();
    }



}
