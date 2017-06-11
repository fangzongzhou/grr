package com.fzz.service;

import com.fzz.dao.UserDao;
import com.fzz.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fzz on 2017/5/14.
 */
@Service
public class DocService {


    @Autowired
    UserDao userDao;
    public void getUserDocModel(int userid) throws IOException {
        FileInputStream temInputStream=new FileInputStream(new File("F:/template.doc"));
        HWPFDocument doc = new HWPFDocument(temInputStream);
        Range bodyRange=doc.getRange();
        Map<String, String> contentMap = new HashMap<String, String>();
        User user=userDao.findOne(userid);
        contentMap.put("name",user.getUsername() );
        Calendar calenda=Calendar.getInstance();
       // JdbcTemplate jdbcTemplate=new JdbcTemplate()


        contentMap.put("date",calenda.get(Calendar.YEAR)+"年"+(calenda.get(Calendar.MONTH)+1)+"月"+calenda.get(Calendar.DAY_OF_MONTH)+"日"  );

        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        doc.write(byteArrayOutputStream);
        OutputStream outputStream1=new FileOutputStream("F:/result.doc");
        outputStream1.write(byteArrayOutputStream.toByteArray());
        outputStream1.close();

    }

    private void build(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception {
        FileInputStream tempFileInputStream = new FileInputStream(tmpFile);

        HWPFDocument document = new HWPFDocument(tempFileInputStream);
        // 读取文本内容
        Range bodyRange = document.getRange();
        // 替换内容
        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }

        //导出到文件
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);

        OutputStream outputStream = new FileOutputStream(exportFile);

        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.close();
    }


    public void testExportWord() throws Exception {
        String tmpFile = "F:/template.doc";
        String expFile = "F:/result.doc";
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("title", "标题部份");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
        datas.put("author", "知识林");
        datas.put("url", "http://www.zslin.com");

        build(new File(tmpFile), datas, expFile);
    }

    public static void main(String[] args) throws Exception {

        new DocService().testExportWord();
    }
}
