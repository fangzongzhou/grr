package com.fzz;

import com.fzz.util.FileUtil;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

/**
 * Created by tuyoo on 2017/4/6.
 */
public class qwer {
    public static void main(String[] args) {
        Gson gson=new Gson();

        String string= FileUtil.readTxtFile("/Users/tuyoo/Documents/config_online/game/9999/item/0.json");
        System.out.println(string);
        Map<String,List> map=gson.fromJson(string,Map.class);
        System.out.println(map.get("items").size());
        List items=map.get("items");
        for (Object o:items
             ) {
            Map<String,Object> map1=(Map<String, Object>) o;

            System.out.print(map1.get("displayName")+" ：" );
            System.out.println(map1.get("kindId") );
        }
        
    }
}
