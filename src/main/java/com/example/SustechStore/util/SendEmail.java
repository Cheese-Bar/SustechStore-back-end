package com.example.SustechStore.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {
    public static int sendEmail(String to) {
        //sender
//        String from = "2894570234@qq.com";
        String from = "ooadtest@qq.com";
        if (!to.contains("@"))
            to = to + "@mail.sustech.edu.cn";
        Random random = new Random();
        int text = random.nextInt(900000) + 100000;//生成6位数随机数

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.user", from);

//        props.put("mail.user", "2894570234@qq.com");

        props.put("mail.password", "wacalailyefadcdg");
//        props.put("mail.smtp.port", "25");
//        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.starttls.enable", "true");

//        props.setProperty("mail.smtp.socketFactory.class", javax.net.ssl.SSLSocketFactory);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.debug","true");
        // 获取默认session对象
//        Session session = Session.getDefaultInstance(props, new Authenticator() {
//            public PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(
//                        "2894570234@qq.com",
//                        "wacalailyefadcdg"); //发件人邮件用户名、授权码
//            }
//        });

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "ooadtest@qq.com",
                        "wxkxyjulyvxvcjfg"); //发件人邮件用户名、授权码
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Sustore验证码");
            message.setText("验证码: " + String.valueOf(text) + "\n您好!\n你正在登录Sustech Store，请输入验证码: " + String.valueOf(text) + " (2分钟内有效)\n请勿泄露此验证码给他人\n如非本人操作，请忽略此邮件");

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return text;
    }


}