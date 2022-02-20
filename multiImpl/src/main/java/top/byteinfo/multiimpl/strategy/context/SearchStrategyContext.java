package top.byteinfo.multiimpl.strategy.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.byteinfo.multiimpl.SearchStrategy;

import java.util.List;

@Service
public class SearchStrategyContext {

    @Autowired
    private SearchStrategy searchStrategy;

    /**
     *
     * @param keywords
     * @return
     */
    public List<String> execte(String keywords){
        return searchStrategy.searchArticle(keywords);
    }

}
