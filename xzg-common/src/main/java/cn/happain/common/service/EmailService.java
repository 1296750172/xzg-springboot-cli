package cn.happain.common.service;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @创建人 happain
 * @创建时间 2023/1/25
 * @描述
 */

@Service
@Slf4j
public class EmailService {
    @Resource
    private JavaMailSender javaMailSender;

    private String fromEmail ="1296750172@qq.com";
    /**
     * 发送
     *
     * @param mailFrom     邮件从
     * @param mailFromNick 邮件发送人名称
     * @param mailTo       邮件
     * @param cc           cc
     * @param subject      主题
     * @param content      内容
     * @throws MessagingException 通讯异常
     */
    public void send(String mailFrom, String mailFromNick, String mailTo, String cc, String subject, String content,boolean isHtml) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(new InternetAddress(fromEmail));
        // 设置多个收件人
        String[] toAddress = mailTo.split(",");
        mimeMessageHelper.setTo(toAddress);
        if (!StrUtil.isEmpty(cc)) {
            mimeMessageHelper.setCc(cc);
        }
        mimeMessageHelper.setSubject(subject);
        // 第二个参数为true表示邮件正文是html格式的，默认是false
        mimeMessageHelper.setText(content, isHtml);
        javaMailSender.send(mimeMessage);
    }


    /**
     * 简单发送
     *
     * @param mailTo  邮件
     * @param cc      cc
     * @param subject 主题
     * @param content 内容
     * @throws MessagingException 通讯异常
     */
    public void sendSimple(String mailTo, String cc, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(new InternetAddress(fromEmail));
        // 设置多个收件人
        String[] toAddress = mailTo.split(",");
        mimeMessageHelper.setTo(toAddress);
        if (!StrUtil.isEmpty(cc)) {
            mimeMessageHelper.setCc(cc);
        }
        mimeMessageHelper.setSubject(subject);
        // 第二个参数为true表示邮件正文是html格式的，默认是false
        mimeMessageHelper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }
}
