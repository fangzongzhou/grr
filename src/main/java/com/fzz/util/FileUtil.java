package com.fzz.util;

import java.io.*;

/**
 * Created by tuyoo on 2017/3/16.
 * 文件工具类
 */
public class FileUtil {
    /*
    * 文件保存到本地
    *文件工具
    * */
    public boolean save(String filename,byte[] file_byte) {
        try {
            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(new File(filename)));
            out.write(file_byte);
            out.flush();
            out.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
