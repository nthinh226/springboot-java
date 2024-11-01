package vn.thinhtn.springbootnyano;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import vn.thinhtn.springbootnyano.util.EmailSenderUtil;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    void sendTextEmail() {
        String to = "ngocthinh1126@gmail.com";
        String subject = "Test OTP Simple";
        String content = "This is a test 1234";

        emailSenderUtil.sendTextEmail(to, subject, content);

    }

    @Test
    void sendHTMLEmail() throws IOException {

        String to = "ngocthinh1126@gmail.com";
        String subject = "Test OTP HTML";
        String content = "OTP is 1234";

        Resource resource = new ClassPathResource("/template/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendHtmlEmail(to, subject, content);

    }
}
