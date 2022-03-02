package top.byteinfo.mq.rabbitmq.blog.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.byteinfo.mq.rabbitmq.blog.dto.MaxwellDataDTO;
import top.byteinfo.mq.rabbitmq.blog.entity.Article;

import static top.byteinfo.mq.rabbitmq.blog.constant.MQPrefixConst.MAXWELL_QUEUE;

/**
 *
 * https://maxwells-daemon.io/
 This is Maxwell's daemon, an application that reads MySQL binlogs and writes row updates as JSON to Kafka,
 Kinesis, or other streaming platforms. Maxwell has low operational overhead, requiring nothing but mysql and a place to write to.
 Its common use cases include ETL, cache building/expiring, metrics collection, search indexing and inter-service communication.
 Maxwell gives you some of the benefits of event sourcing without having to re-architect your entire platform.
 *
 * maxwell监听数据
 *
 * @author yezhiqiu
 * @date 2021/08/02
 */
@Component
@RabbitListener(queues = MAXWELL_QUEUE)
@Slf4j
public class MaxWellConsumer {
//    @Autowired
//    private ElasticsearchDao elasticsearchDao;

    @RabbitHandler
    public void process(byte[] data) {
        // 获取监听信息
        MaxwellDataDTO maxwellDataDTO = JSON.parseObject(new String(data), MaxwellDataDTO.class);
        // 获取文章数据
        Article article = JSON.parseObject(JSON.toJSONString(maxwellDataDTO.getData()), Article.class);
        // 判断操作类型
        switch (maxwellDataDTO.getType()) {
            case "insert":
            case "update":
                // 更新es文章
//                elasticsearchDao.save(BeanCopyUtils.copyObject(article, ArticleSearchDTO.class));
                log.info("更新es文章");
                break;
            case "delete":
                // 删除文章
//                elasticsearchDao.deleteById(article.getId());
                log.info("删除文章");
                break;
            default:
                break;
        }
    }

}