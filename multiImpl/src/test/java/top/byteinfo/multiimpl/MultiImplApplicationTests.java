package top.byteinfo.multiimpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.byteinfo.multiimpl.strategy.SearchStrategy;
import top.byteinfo.multiimpl.strategy.context.PayStrategyContext;
import top.byteinfo.multiimpl.strategy.impl.WeChatPayStrategy;

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

    @Autowired
    WeChatPayStrategy weChatPayStrategy;


    @Autowired
    PayStrategyContext payStrategyContext;

    static int[] t1() {
        int[] inta = {1, 2, 34, 6};
        return inta;
    }

    @Test
    int t2() {
        return t1()[0];
    }
    static String t3(){
        String[] strings={
                "s1","s2","s3"
        };
        return strings[1];
    }



    @Test
    void contextLoads() {
        searchStrategy.searchArticle("");
        System.out.println(t3());
        payStrategyContext.getStrategy(BizTypeEnum.Alipay).bizProcess(new RequestDTO());

    }

}
