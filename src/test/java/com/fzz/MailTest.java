package com.fzz;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fzz.controller.ModelTest;
import com.fzz.service.EmailService;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafTemplateAvailabilityProvider;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huayu on 2017/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private JavaMailSender sender;
    @Test
    public void sendMail() {
        //简单文本文件测试

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("fangzongzhou@qq.com");
        message.setTo("1944288097@qq.com");
        message.setText("cahisyoujian");

        System.out.println("fasongzyou");

        sender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        MimeMessage mimeMessage =sender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("fangzongzhou@qq.com");
        helper.setTo("1944288097@qq.com");
        helper.setSubject("youfujian");
        helper.setText("a发送的");
        FileSystemResource file=new FileSystemResource(new File("C:\\Users\\huayu\\Desktop\\数据库连接池\\20150717155541525.png"));
        helper.addAttachment("fujian.jpg",file);
        sender.send(mimeMessage);
    }

    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("fangzongzhou@qq.com");
        helper.setTo("1944288097@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

        FileSystemResource file=new FileSystemResource(new File("C:\\Users\\huayu\\Desktop\\数据库连接池\\20150717155541525.png"));
        helper.addInline("weixin", file);

        sender.send(mimeMessage);

    }


    @Test
    public void sendTemplateMail() throws Exception {

        MimeMessage mimeMessage = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("fangzongzhou@qq.com");
        helper.setTo("1944288097@qq.com");
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashMap();
        model.put("username", "didi");
        ModelAndView modelAndView=new ModelAndView("mailhello");
        modelAndView.addObject("username","fangyong");


//        String text = new ModelAndView("mailhello",model).toString();//thymeleaf
//        String text = VelocityEngineUtils.mergeTemplateIntoString(
//                velocityEngine, "template.vm", "UTF-8", model);

        helper.setText("xiaofang");



        sender.send(mimeMessage);
    }

    @Autowired
    EmailService emailService;
    @Test
    public void asdf() throws MessagingException {
        emailService.prepareAndSendEmail();
        System.out.println("xiaohuo");
    }

}
