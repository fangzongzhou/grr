package com.fzz.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

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

    //获取该参数路径下的所有文件文件名,深度遍历
    public void fileIterator(String dirPath){

        File path =new File(dirPath);
        if (!path.isDirectory()) {
            throw new IllegalArgumentException(dirPath+": 不是一个目录路径");
        }
        File[] files=path.listFiles();
        for (File f:files     ) {
            if (f.isDirectory()) {
                this.fileIterator(f.getAbsolutePath());//递归操作
            }
            else {
                System.out.println(dirPath+"\\"+f.getName());

            }
        }
    }

    public void randomAccessFile() throws IOException {
        File file=new File("E:\\workspace\\idea\\grr\\src\\main\\resources\\static\\test.html");
        RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
        randomAccessFile.seek(0);
        byte[] bytes=new byte[(int)randomAccessFile.length()];
        randomAccessFile.read(bytes);
        System.out.println(Arrays.toString(bytes));
    }
}
