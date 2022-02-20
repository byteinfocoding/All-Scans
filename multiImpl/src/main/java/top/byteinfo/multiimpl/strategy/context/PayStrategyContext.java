package top.byteinfo.multiimpl.strategy.context;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import top.byteinfo.multiimpl.BizTypeEnum;
import top.byteinfo.multiimpl.strategy.PayStrategy;

import java.util.EnumMap;
import java.util.Map;
@Component
public class PayStrategyContext implements BeanPostProcessor {
    private final Map<BizTypeEnum, PayStrategy> strategies = new EnumMap<>(BizTypeEnum.class);

    /**
     * 根据业务类型获取策略对象
     *
     * @param ruleType 规则类型
     * @return 策略对象
     */

    public PayStrategy getStrategy(BizTypeEnum ruleType) {
        return strategies.get(ruleType);
    }

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//    }
    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        if (bean instanceof PayStrategy) {
            PayStrategy Paystrategy = (PayStrategy) bean;
            strategies.put(Paystrategy.getBizType(), Paystrategy);

            System.out.println("strategy {} registered"+","+beanName);
        }
        return bean;
    }

}
