package top.byteinfo.multiimpl.strategy.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import top.byteinfo.multiimpl.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnProperty(prefix ="search.mode", name ="elasticsearch", havingValue ="true" /*, matchIfMissing = true*/)
public class EsSearchStrategyImpl implements SearchStrategy {
    @Override
    public List<String> searchArticle(String keywords) {

        List<String> stringList = new ArrayList<>();

        stringList.add("\n"+"elasticsearch !\n");
        stringList.add("elasticsearch is more faster !\n");
        stringList.add("elasticsearch is more faster and efficient!\n");
        return stringList;
    }
}
