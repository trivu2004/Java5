package com.example.ASM.Controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestParam("to") String to,
                                           @RequestParam("phone") String phone,
                                           @RequestParam("address") String address,
                                           @RequestParam("subject") String subject,
                                           @RequestParam("delivery") String delivery,
                                           @RequestParam("content") String content,
                                           @RequestParam("file") MultipartFile file,
                                           @RequestParam(value = "file1", required = false) MultipartFile file1) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText("SĐT: " + phone + "\nĐịa ch: " + address + "\nGiao hàng: " + delivery + "\n\n" + content);

            if (!file.isEmpty()) {
                InputStreamSource attachment = new ByteArrayResource(file.getBytes());
                helper.addAttachment(file.getOriginalFilename(), attachment);
            }

            if (file1 != null && !file1.isEmpty()) {
                InputStreamSource attachment = new ByteArrayResource(file1.getBytes());
                helper.addAttachment(file1.getOriginalFilename(), attachment);
            }

            javaMailSender.send(message);

            return new ResponseEntity<>("Vui lòng đợi phản hồi của CT Mobile!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error sending email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
