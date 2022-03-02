package top.byteinfo.mq.rabbitmq.blog.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.mq.rabbitmq.blog.dto.EmailDTO;

import static java.lang.Boolean.TRUE;
import static top.byteinfo.mq.rabbitmq.blog.constant.MQPrefixConst.EMAIL_EXCHANGE;

@RestController
@RequestMapping
public class HomeController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/t1")
    void t1(){

//        String email = userInfoDao.selectById(userId).getEmail();
        String email = "userInfoDao.selectById(userId).getEmail()";
        EmailDTO emailDTO = new EmailDTO();
//        if (comment.getIsReview().equals(TRUE)) {
        if (TRUE) {
            // 评论提醒
            emailDTO.setEmail(email);
            emailDTO.setSubject("评论提醒");
            // 获取评论路径
//            String url = websiteUrl + getCommentPath(comment.getType()) + id;
            String url = "websiteUrl + getCommentPath(comment.getType()) + id";
            emailDTO.setContent("您收到了一条新的回复，请前往" + url + "\n页面查看");
        } else {
            // 管理员审核提醒
            String adminEmail = "userInfoDao.selectById(BLOGGER_ID).getEmail()";
            emailDTO.setEmail(adminEmail);
            emailDTO.setSubject("审核提醒");
            emailDTO.setContent("您收到了一条新的回复，请前往后台管理页面审核");
        }
        rabbitTemplate.convertAndSend(EMAIL_EXCHANGE, "*", new Message(JSON.toJSONBytes(emailDTO), new MessageProperties()));
    }
}
