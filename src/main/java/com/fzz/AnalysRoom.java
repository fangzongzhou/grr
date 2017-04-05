package com.fzz;

import com.fzz.util.FileUtil;
import com.google.gson.Gson;

import java.io.File;
import java.util.Map;

/**
 * Created by tuyoo on 2017/4/5.
 */
public class AnalysRoom {
    public static void main(String[] args) {
        String path="/Users/tuyoo/Documents/config_online/game/";
        File file=new File(path);
        if (file.isDirectory()) {
            File[] files=file.listFiles();
            for (File f:files
                 ) {
                System.out.println(f.getName());
                if(isNumeric(f.getName())&&!f.getName().equals("3")){
                    String roompath="/Users/tuyoo/Documents/config_online/game/"+f.getName()+"/room/";
                    getroomname(roompath);
                }
                System.out.println("------------------------------------------------------------------"+f.getName());


            }
        }
//        String roompath="/Users/tuyoo/Documents/config_online/game/7/room/";
//        getroomname(roompath);
    }

    public static void getroomname(String roompath) {
        String filepath=roompath;
        File file=new File(filepath);
        Gson gson=new Gson();
        String jsonstr="";
        if (file.isDirectory()) {
            File[] files=file.listFiles();
            for (File f:files
                    ) {
                String filename=filepath+f.getName();

                jsonstr= FileUtil.readTxtFile(filename);
                Map<String,Object> map=gson.fromJson(jsonstr,Map.class);
                System.out.print(f.getName().substring(0,f.getName().indexOf(".")));
                System.out.println(": "+map.get("name"));
            }
        }else {
            System.out.println("not a directory");
        }
    }

    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
