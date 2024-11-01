package vn.thinhtn.springbootnyano.service.impl;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import vn.thinhtn.springbootnyano.entity.mail.EmailEntity;
import vn.thinhtn.springbootnyano.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    private static final String EMAIL_HOST = "ngocthinh.work@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendTextEmail(EmailEntity email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getMessageBody());
        message.setFrom(EMAIL_HOST);

        try {
            javaMailSender.send(message);
            System.out.println("Email sent Successfully");
            return "Email sent Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendHtmlEmail(EmailEntity email) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(EMAIL_HOST);
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getMessageBody(), true);
            javaMailSender.send(message);

            System.out.println("Email sent HTMLs Successfully");
            return "Email sent Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendMailAttachmentEmail(EmailEntity email) {
        return "";
    }
}
