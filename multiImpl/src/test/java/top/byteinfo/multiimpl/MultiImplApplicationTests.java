package top.byteinfo.multiimpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.byteinfo.multiimpl.strategy.SearchStrategy;
import top.byteinfo.multiimpl.strategy.impl.WeChatPayStrategy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MultiImplApplicationTests {

    @Autowired
    SearchStrategy searchStrategy;

    /**
     * not recommended
     * But,
     * Need to learn its principle or sourcecode
     */
    @Autowired
    private Map<String, SearchStrategy> searchStrategyMap;


    private final Map<BizTypeEnum, SearchStrategy> strategies = new EnumMap<>(BizTypeEnum.class);

    /**
     * 根据业务类型获取策略对象
     *
     * @param ruleType 规则类型
     * @return 策略对象
     */
    public SearchStrategy getStrategy(BizTypeEnum ruleType) {
        return strategies.get(ruleType);
    }

    @Autowired
    WeChatPayStrategy weChatPayStrategy;


    static int[] t1() {
        int[] inta = {1, 2, 34, 6};

        return inta;
    }

    @Test
    int t2() {
        return t1()[0];
    }

    @Test
    void contextLoads() {

        System.out.println(t2());

        List<String> stringList = searchStrategy.searchArticle("ssss");

        System.out.println(stringList);

        BizTypeEnum bizType = weChatPayStrategy.getBizType();
    }

}
