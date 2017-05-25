package com.fzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by huayu on 2017/5/13.
 */
@Service
public class EmailService {
    private static TemplateEngine templateEngine;
    private static Context context;

    @Autowired
    private JavaMailSender emailSender;

    private Logger LOG = LoggerFactory.getLogger(EmailService.class);



    public void prepareAndSendEmail() throws MessagingException {
        String htmlTemplate = "templates/mailhello";
        String mailTo = "1944288097@qq.com";
        initializeTemplateEngine();

        context.setVariable("sender", "Thymeleaf Email");
        context.setVariable("username", mailTo);


        String htmlBody = templateEngine.process(htmlTemplate, context);

        sendEmail(mailTo, "Thymeleaf Email Demo", htmlBody);
    }

    public void mysendmail(String subject, String[] tousers, String text, List<MultipartFile> files) throws MessagingException {
        MimeMessage message=emailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);
        messageHelper.setText(text);
        messageHelper.setSubject(subject);
        messageHelper.setTo(tousers);
        messageHelper.setFrom("fangzongzhou@qq.com");
        Iterator<MultipartFile> iterator=files.iterator();
        while (iterator.hasNext()){
            MultipartFile multipartFile=iterator.next();
            messageHelper.addAttachment(multipartFile.getOriginalFilename(),multipartFile);
        }
        emailSender.send(message);
    }

    private void sendEmail(String mailTo, String subject, String mailBody) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("fangzongzhou@qq.com");
        helper.setTo(mailTo);
        helper.setSubject(subject);
        helper.setText(mailBody, true);
        emailSender.send(message);
        LOG.info("Email sent to " + mailTo);
    }

    private static void initializeTemplateEngine() {

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("HTML5");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        context = new Context(Locale.US);

    }

    public void sendTextMail(String senderUserName,String senderPassword) {
        JavaMailSenderImpl mailSender =getMailSender(senderUserName,senderPassword);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("1944288097@qq.com");
        mailMessage.setFrom("fangzongzhou@qq.com");
        mailMessage.setSubject("ceshiyoujian");
        mailMessage.setText("shishihaobuahowhi");
        mailSender.send(mailMessage);
    }

    private JavaMailSenderImpl getMailSender(String username,String password) {
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");//腾讯SMTP服务器

        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.timeout", "25000");
        properties.put("mail.smtp.ssl.enable","true");//腾讯邮箱发送邮件需求
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
