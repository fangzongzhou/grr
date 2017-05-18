package com.fzz.service;

import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by huayu on 2017/5/18.
 */
@Service
public class TxtService {
    public void readFileByLines(String fileName){
        File file=new File(fileName);
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new FileReader(file));
            String tempString=null;
            int i=1;
            while ((tempString=reader.readLine())!=null){
                System.out.println((i++)+". "+tempString);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
