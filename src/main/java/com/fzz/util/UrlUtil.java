package com.fzz.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

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
                //System.out.println(str);
                response_str.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response_str.toString();
    }

    public String doPost(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keySet = params.keySet();
        for(String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }
        //结果
        CloseableHttpResponse response = null;
        String content="";
        try {
            //提交的参数
            UrlEncodedFormEntity uefEntity  = new UrlEncodedFormEntity(nvps, "UTF-8");
            //将参数给post方法
            httpPost.setEntity(uefEntity);
            //执行post方法
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                content = EntityUtils.toString(response.getEntity(),"utf-8");

            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;

    }

    public static void main(String[] args) {
        UrlUtil urlUtil=new UrlUtil();
        Map<String,String> map =new HashMap<>();
        map.put("username","577");
        map.put("password","577");
        map.put("this_is_the_login_form","1");
        String res=urlUtil.doPost("http://192.168.10.254/iclock/accounts/login/",map);
        String qwer=urlUtil.get_Response_Str("http://192.168.10.254/iclock/staff/transaction/?UserID__id__exact=574&fromTime=&toTime=");
        System.out.println(res);
        System.out.println(qwer);

    }



}
