package com.woniu.movie.util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 功能描述:<br>
 * 调用sendEmail()方法，可以向用户的邮箱发送验证信息
 *
 * @author 李志祥
 * @create 2019/10/21
 * @since 1.0.0
 */
@Component
public class MailUtils {

    /*
     *@param fromEmail 必须是1181580150@qq.com
     *@param toEmail   用户邮箱
     *@param emailMsg   发送给用户的信息！
     * */
    public static boolean sendEmail(String fromEmail, String toEmail, String emailMsg) throws MessagingException, MessagingException {
        Properties prop = new Properties();
        //固定写法，qq的SMTP服务器地址就是stmp.qq.com！
        prop.setProperty("mail.host", "stmp.qq.com");
        //设置传输协议
        prop.setProperty("mail.transport.protocol", "smtp");
        //设置用户的认证方式
        prop.setProperty("mail.smtp.auth", "true");
        /*       prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");*/

        //使用javaMail发送邮件的5个步骤
        //创建session
        Session session = Session.getInstance(prop);
        //2.通过session得到transport对象
        Transport ts = session.getTransport();
        //3.使用邮箱的用户名和密码链接上邮件服务器，发送邮件时，发送人需要提交邮箱的用户名和密码（授权码）给smtp服务器，用户名和密码都通过验证之后
        //才能够正常发送邮件给收件人，QQ邮箱需要使用SSL，端口号465或587       ts.connect("smtp.qq.com",587,"QQ号","授权码");
        ts.connect("smtp.qq.com", 587, "1181580150", "qxarmmpvvudihcda");
        //4、创建邮件
        Message message;
        try {
            message = createSimpleMail(fromEmail, toEmail, emailMsg, session);
            //5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ts.close();
        return true;
    }

    /**
     * 创建邮件
     */
    public static Message createSimpleMail(String fromEmail, String toEmail, String emailMsg, Session session) throws AddressException, MessagingException {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发送人
        message.setFrom(new InternetAddress(fromEmail));
        //指明收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        //设置邮件的标题
        message.setSubject("用户激活", "UTF-8");
        //设置邮件的内容
        message.setContent(emailMsg, "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

}
