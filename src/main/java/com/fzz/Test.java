package com.fzz;

import com.fzz.service.impl.UserServiceImpl;

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
        UserServiceImpl userServiceImplImpl =new UserServiceImpl();
        userServiceImplImpl.register("xiaofang","xiaofff");

    }
}
