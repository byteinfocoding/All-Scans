package top.byteinfo.multiimpl.strategy.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import top.byteinfo.multiimpl.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
@Service
@ConditionalOnProperty(prefix ="search.mode", name ="mysql", havingValue ="true" /*, matchIfMissing = true*/)
public class MySqlSearchStrategyImpl implements SearchStrategy {
    @Override
    public List<String> searchArticle(String keywords) {
        List<String> stringList = new ArrayList<>();

        stringList.add("MySql");
        stringList.add("MySql is simpler");
        stringList.add("MySql is simpler and more stable");
        return stringList;
    }
}
