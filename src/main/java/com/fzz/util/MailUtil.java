package com.fzz.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by fzz on 2017/2/25
 * 邮件工具.
 */
public class MailUtil {
    public static void main(String[] args) throws GeneralSecurityException, MessagingException, IOException {

        MailUtil mailUtil=new MailUtil();
        String Address="1944288097@qq.com;2215523266@qq.com;";
        mailUtil.sendMail("fzz邮件","fzz521477@foxmail.com","fzz521477@foxmail.com","zdcmjpfedrqjbdbe",Address);
    }

    private Properties getmailProperties() {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        //开启ssl验证,qq邮箱特有的
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        return props;
    }

    public void sendMail(
            String subject,
            String internetAddress,
            String username,
            String password,
            String toaddress
    ) throws GeneralSecurityException, MessagingException {


        //通过配置新建会话

        Session session = Session.getInstance(this.getmailProperties());

        //创建消息对话
        Message message = new MimeMessage(session);
        //设置邮件主题
        message.setSubject(subject);
        message.setFrom(new InternetAddress(internetAddress));

        MimeMultipart mimeMultipart = new MimeMultipart();

        // 新建一个存放信件内容的BodyPart对象
        BodyPart mdp = new MimeBodyPart();
        // 给BodyPart对象设置内容和格式/编码方式
        mdp.setContent("<a href=\"http://www.baidu.com\">baidu</a>"+ "<img src = \"cid:logo_jpg\"></a>", "text/html;charset=utf-8");
        // 将mime协议bodypart添加
        mimeMultipart.addBodyPart(mdp);

        mdp = new MimeBodyPart();
        // DataHandler dh = new DataHandler(new ByteArrayDataSource(getImageBytes("http://i03.pictn.sogoucdn.com/3c28af542f2d49f7-fe9c78d2ff4ac332-d7247f28ea222792bc4dbd945a213519_qq"), "application/octet-stream"));
        DataHandler dh=new DataHandler(new FileDataSource("F:\\图片\\头像\\fzz.jpg"));

        mdp.setDataHandler(dh);
        //加上这句将作为附件发送,否则将作为信件的文本内容
        mdp.setFileName("二维码图片.png");
        mdp.setHeader("content-id", "logo_jpg");
        mimeMultipart.addBodyPart(mdp);//Multipart加入到信件

        //将附件放入传输的信件文本内容中
        message.setContent(mimeMultipart);

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "fzz521477@foxmail.com", "zdcmjpfedrqjbdbe");

        String[] address=toaddress.split(";");
        Address[] add=new Address[address.length];
        for (int i = 0; i < address.length; i++) {
            add[i]=new InternetAddress(address[i]);
        }

        transport.sendMessage(message,add);
        transport.close();
    }


}
