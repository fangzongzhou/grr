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
                if(isNumeric(f.getName())&&f.getName().equals("6")){
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
                System.out.println(f.getName().substring(0,f.getName().indexOf("."))+"：");
                System.out.println("房间名\t"+map.get("name"));
                System.out.println("是否是比赛:\t" + map.get("ismatch"));
                System.out.println("\t"+map.get("useRoomCount"));
                System.out.println("\t"+map.get("buyinchip"));
                System.out.println("\t"+map.get("dummyUserCount"));
                System.out.println("\t"+map.get("goodCard"));
                System.out.println("\t"+map.get("hasrobot"));
                System.out.println("\t"+map.get("matchConf"));
                System.out.println("\t"+map.get("maxCoin"));
                System.out.println("\t"+map.get("maxCoinQS"));
                System.out.println("\t"+map.get("maxLevel"));
                System.out.println("\t"+map.get("minCoin"));
                System.out.println("\t"+map.get("minCoinQS"));
                System.out.println("\t"+map.get("initScore"));
                System.out.println("快开索引：\t"+map.get("quickIndex"));
                System.out.println("房间花费：\t"+map.get("roomFee"));
                System.out.println("\t"+map.get("roomLevel"));
                System.out.println("\t"+map.get("autoPlay"));
                System.out.println("\t"+map.get("canchat"));

                System.out.println("****************************************");
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
