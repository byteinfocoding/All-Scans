package top.byteinfo.multiimpl.strategy;

import top.byteinfo.multiimpl.BizTypeEnum;
import top.byteinfo.multiimpl.RequestDTO;

public interface PayStrategy {
    /**
     * 执行业务策略
     *
     * dto 入参
     */
    void bizProcess(RequestDTO dto);

    /**
     * 获取当前策略对应的业务类型
     *
     * @return 业务类型
     */
    BizTypeEnum getBizType();

}
