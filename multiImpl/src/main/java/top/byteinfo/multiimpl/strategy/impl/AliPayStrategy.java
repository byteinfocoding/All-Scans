package top.byteinfo.multiimpl.strategy.impl;

import org.springframework.stereotype.Service;
import top.byteinfo.multiimpl.BizTypeEnum;
import top.byteinfo.multiimpl.RequestDTO;
import top.byteinfo.multiimpl.strategy.PayStrategy;

@Service
public class AliPayStrategy implements PayStrategy {
    @Override
    public void bizProcess(RequestDTO dto) {

    }

    @Override
    public BizTypeEnum getBizType() {
        return BizTypeEnum.Alipay;
    }


}
