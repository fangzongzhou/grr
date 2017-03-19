package com.fzz.util;

/**
 * Created by fzz on 2017/3/18.
 */
public class HC_12306Util {
    private UrlUtil urlUtil=new UrlUtil();

    public String getcode() {
        String str1 = urlUtil.get_Response_Str("https://kyfw.12306.cn/otn/resources/js/framework/station_name.js");
        String str2 = urlUtil.get_Response_Str("https://www.baidu.com/");
        System.out.println(str1.equals(str2));
        return " ";
    }

    public static void main(String[] args) {
        HC_12306Util hc_12306Util=new HC_12306Util();
        hc_12306Util.getcode();
    }

}
