package com.fzz;

import com.fzz.util.PathUtil;
import com.fzz.util.RegularExpUtil;
import com.fzz.util.UrlUtil;

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
        System.out.println(new PathUtil().getProjectPath());


    }
}
