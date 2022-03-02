package top.byteinfo.mq.mallmq.mall.ampb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的消费者
 * Created by macro on 2018/9/14.
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    private static Logger LOGGER =LoggerFactory.getLogger(CancelOrderReceiver.class);

    @RabbitHandler
    public void handle(Long orderId){

        LOGGER.info("process orderId:{}",orderId);
        LOGGER.info("===================");
        LOGGER.info("===================");
        LOGGER.info("===================");
    }
}
