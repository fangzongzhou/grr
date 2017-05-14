package com.fzz.controller;

import com.fzz.service.EmailService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by fzz on 2017/5/14.
 */
@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    EmailService mailService;

    @RequestMapping("test")
    public ModelAndView testSendMail(

    ) {
        return new ModelAndView("mailtest");
    }
    @RequestMapping("sendmail")
    public String sendmail(
            HttpServletRequest request,
            @RequestParam("text") String text,
            @RequestParam("receiver")String[] tolist,
            @RequestParam("subject") String subject

            ) throws MessagingException {

        mailService.mysendmail(subject,tolist,text,((MultipartHttpServletRequest)request).getFiles("files"));

        return "successful";

    }
}
