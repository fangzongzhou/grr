package com.fzz.util;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tuyoo on 2017/3/16.
 * 文件工具类
 */
public class FileUtil {
    /*
    * 文件保存到本地
    *
    * */
    public boolean save2Local(String filename,byte[] file_byte) {
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



    

    public static void main(String[] args) throws IOException {

        FileUtil.readTxtFile("/Users/tuyoo/Documents/config_online/game/6/room/6057.json");
        
    }


    /*
    * 拷贝文件
    * */
    public static void copyFileByBuffer(File srcFile, File destFile) throws IOException{
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("源文件:"+srcFile.getAbsolutePath()+" 不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile+":不是文件");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(destFile));
        int r;
        byte[] buf=new byte[8*1024];
        while ((r = bufferedInputStream.read(buf,0,buf.length)) != -1) {
            bufferedOutputStream.write(buf);
            bufferedOutputStream.flush();
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    //获取当前路径下所有非文件夹的文件
    public List<String> getTimePathFilename(String dirPath) {

        List<String> filenames=new ArrayList<String>();
        File path =new File(dirPath);
        if (!path.isDirectory()) {
            throw new IllegalArgumentException(dirPath+": 不是一个目录路径");
        }
        File[] files=path.listFiles();
        String str;
        for (File f:files     ) {

            if(!f.isDirectory()) {
                str=dirPath+"/"+f.getName();
                //System.out.println(str);
                filenames.add(str);

            }
        }
        return filenames;
    }

    //获取该参数路径下的所有文件文件名,深度遍历
    public List<String> getAllFileList(String dirPath,List<String> filenames){


        File path =new File(dirPath);
        if (!path.isDirectory()) {
            throw new IllegalArgumentException(dirPath+": 不是一个目录路径");
        }
        File[] files=path.listFiles();
        String str;
        for (File f:files     ) {
            if (f.isDirectory()) {
                this.getAllFileList(f.getAbsolutePath(),filenames);//递归操作
            }
            else {
                str=dirPath+"/"+f.getName();
                //System.out.println(str);
                filenames.add(str);

            }
        }
        return filenames;
    }

    public void randomAccessFile() throws IOException {
        File file=new File("二维若群翁");
        RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
        randomAccessFile.seek(0);
        byte[] bytes=new byte[(int)randomAccessFile.length()];
        randomAccessFile.read(bytes);
        System.out.println(Arrays.toString(bytes));
    }

    public static String readTxtFile(String filePath){
        StringBuilder res=new StringBuilder();
        try {
            String encoding="UTF-8";
            File file=new File(filePath);

            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);

                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    res.append(lineTxt);
                }
                read.close();
                return res.toString();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return res.toString();
    }
}
