package top.byteinfo.multiimpl.strategy.impl;

import org.springframework.stereotype.Service;
import top.byteinfo.multiimpl.BizTypeEnum;
import top.byteinfo.multiimpl.RequestDTO;
import top.byteinfo.multiimpl.strategy.PayStrategy;

import java.util.ArrayList;
import java.util.List;

@Service
public class AliPayStrategy implements PayStrategy {
    @Override
    public void bizProcess(RequestDTO dto) {
        List<String> stringList = new ArrayList<>();
        stringList.add("AliPay");
        stringList.add("AliPay is simpler");
        stringList.add("AliPay is simpler and more stable");
        System.out.println(stringList);

    }

    @Override
    public BizTypeEnum getBizType() {
        return BizTypeEnum.Alipay;
    }


}
