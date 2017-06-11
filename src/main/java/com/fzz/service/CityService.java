package com.fzz.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by huayu on 2017/6/11.
 */
@Service
public class CityService {

    public static final String ALLPROVIENCE="辽宁,吉林,黑龙江,河北,山西,陕西,山东," +
            "安徽,江苏,浙江,河南,湖北,湖南,江西,台湾,福建,云南,海南,四川,贵州,广东,甘肃,青海,西藏,新疆,广西,内蒙古,宁夏,北京,天津,上海,重庆";
    public List<String> getAllCity() {
        List<String> citys = new ArrayList<>();
        String[] asdf=CityService.ALLPROVIENCE.split(",");
        for (String c:asdf
             ) {
            citys.add(c);
        }
        return citys;

    }
}
