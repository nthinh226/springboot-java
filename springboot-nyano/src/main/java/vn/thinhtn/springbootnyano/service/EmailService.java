package vn.thinhtn.springbootnyano.service;

import vn.thinhtn.springbootnyano.entity.mail.EmailEntity;

public interface EmailService {
    String sendTextEmail(EmailEntity email);

    String sendHtmlEmail(EmailEntity email);

    String sendMailAttachmentEmail(EmailEntity email);
}
