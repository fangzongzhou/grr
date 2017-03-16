package com.fzz.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuyoo on 2017/3/16.
 * 正则表达式工具
 */
public class RegularExpUtil {

    public List<String> getMatchingResult(String sourceStr, String reg_exp) {
        List<String> result=new ArrayList<String>();
        Pattern pattern = Pattern.compile(reg_exp);
        Matcher matcher = pattern.matcher(sourceStr);
        // 字符串是否与正则表达式相匹配

        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;

    }

    public boolean is_matching(String tocheck_str, String reg_exp) {
        Pattern pattern = Pattern.compile(reg_exp);
        Matcher matcher = pattern.matcher(tocheck_str);
        return matcher.matches();

    }
}
