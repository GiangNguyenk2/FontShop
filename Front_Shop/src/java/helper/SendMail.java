/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dinhd513
 */
public class SendMail {

    public void SendGmail(String sendToGmail, String supject, String text) {
        String from = "dinhd513@gmail.com";
        String pass = "xkctidnkhnyupnrl";

        // Cài đặt thuộc tính host, port, protocol cho session
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Tạo một phiên gửi email với thông tin đăng nhập
        Session session;
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });

        try {
            // Tạo một đối tượng Message
            Message message = new MimeMessage(session);
            // Thiết lập người gửi email
            message.setFrom(new InternetAddress(from));
            // Thiết lập người nhận email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(sendToGmail));
            // Thiết lập tiêu đề email
            message.setSubject(supject);
            // Thiết lập nội dung email
            message.setText(text);

            // Gửi email
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
