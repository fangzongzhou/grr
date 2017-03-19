package com.fzz.controller;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by fzz on 2017/3/19.
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    @RequestMapping("/check")
    public String checkcode(
            @RequestParam(value = "checkcode") String checkcode,
            HttpSession httpSession
            ) {
        if (checkcode.equals(httpSession.getAttribute("checkcode"))) {
            return "check code ok";
        }
        return "check code error";

    }

    @RequestMapping("/checkcode")
    public void checkcode(
            HttpSession httpSession,
            ServletResponse servletResponse
    ) throws IOException {
        BufferedImage bufferedImage=new BufferedImage(68,22,BufferedImage.TYPE_3BYTE_BGR);
        Graphics graphics=bufferedImage.getGraphics();
        Color c = new Color(200, 150, 155);
        graphics.setColor(c);
        graphics.fillRect(0, 0, 68, 22);
        char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r = new Random();
        int len=ch.length;
        int index;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<4;i++) {
            index=r.nextInt(len);
            graphics.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
            graphics.drawString(ch[index]+"",i*15+3,18);
            stringBuffer.append(ch[index]);
        }
        httpSession.setAttribute("checkcode", stringBuffer.toString());
        ImageIO.write(bufferedImage,"JPG",servletResponse.getOutputStream());
    }
}
