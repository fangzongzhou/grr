package com.fzz.util.https;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;
//对接口进行测试  
public class TestMain {
    private String url = "https://192.168.1.101/";
    private String charset = "utf-8";
    private HttpClientUtil httpClientUtil = null;

    public TestMain(){
        httpClientUtil = new HttpClientUtil();
    }

    public void test(){
        String httpOrgCreateTest = url + "httpOrg/create";
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("authuser","*****");
        createMap.put("authpass","*****");
        createMap.put("orgkey","****");
        createMap.put("orgname","****");
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
        System.out.println("result:"+httpOrgCreateTestRtn);
    }

    public static void main(String[] args){
//        TestMain main = new TestMain();
//        main.test();
        HttpClient httpClient=null;
        HttpGet httpGet=null;
        String result="";
        try {
            httpClient = new SSLClient();
            httpGet=new HttpGet("https://kyfw.12306.cn/otn/resources/js/framework/station_name.js");
            HttpResponse response = httpClient.execute(httpGet);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,"utf-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}  