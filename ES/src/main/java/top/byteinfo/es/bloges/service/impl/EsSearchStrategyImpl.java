package top.byteinfo.es.bloges.service.impl;

import lombok.extern.log4j.Log4j2;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import top.byteinfo.es.bloges.service.SearchStrategy;
import top.byteinfo.es.bloges.service.dto.ArticleSearchDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static top.byteinfo.es.bloges.service.model.ArticleStatusEnum.PUBLIC;
import static top.byteinfo.es.bloges.service.model.CommonConst.*;

/**
 * es搜索策略实现
 *
 * @author yezhiqiu
 * @date 2021/07/27
 */
@Log4j2
@Service("esSearchStrategyImpl")
public class EsSearchStrategyImpl implements SearchStrategy {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    //sourcecode
    public static boolean isBlank(CharSequence cs) {
        if (cs != null) {
            int length = cs.length();

            for(int i = 0; i < length; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }




    @Override
    public List<ArticleSearchDTO> searchArticle(String keywords) {

        if (isBlank(keywords)) {
            return new ArrayList<>();
        }
        return search(buildQuery(keywords));
    }

    /**
     * 搜索文章构造
     *
     * @param keywords 关键字
     * @return es条件构造器
     */
    private NativeSearchQueryBuilder buildQuery(String keywords) {
        // 条件构造器
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 根据关键词搜索文章标题或内容
        boolQueryBuilder.must(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("articleTitle", keywords))
                        .should(QueryBuilders.matchQuery("articleContent", keywords)))
                .must(QueryBuilders.termQuery("isDelete", FALSE))
                .must(QueryBuilders.termQuery("status", PUBLIC.getStatus()));
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        return nativeSearchQueryBuilder;
    }

    /**
     * 文章搜索结果高亮
     *
     * @param nativeSearchQueryBuilder es条件构造器
     * @return 搜索结果
     */

    private List<ArticleSearchDTO> search(NativeSearchQueryBuilder nativeSearchQueryBuilder) {
        // 添加文章标题高亮
        HighlightBuilder.Field titleField = new HighlightBuilder.Field("articleTitle");
        titleField.preTags(PRE_TAG);
        titleField.postTags(POST_TAG);
        // 添加文章内容高亮
        HighlightBuilder.Field contentField = new HighlightBuilder.Field("articleContent");
        contentField.preTags(PRE_TAG);
        contentField.postTags(POST_TAG);
        contentField.fragmentSize(200);
        nativeSearchQueryBuilder.withHighlightFields(titleField, contentField);
        // 搜索
        try {
            SearchHits<ArticleSearchDTO> search = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), ArticleSearchDTO.class);
            return search.getSearchHits().stream().map(hit -> {
                ArticleSearchDTO article = hit.getContent();
                // 获取文章标题高亮数据
                List<String> titleHighLightList = hit.getHighlightFields().get("articleTitle");
                if (isNotEmpty(titleHighLightList)) {
                    // 替换标题数据
                    article.setArticleTitle(titleHighLightList.get(0));
                }
                // 获取文章内容高亮数据
                List<String> contentHighLightList = hit.getHighlightFields().get("articleContent");
                if (isNotEmpty(contentHighLightList)) {
                    // 替换内容数据
                    article.setArticleContent(contentHighLightList.get(contentHighLightList.size() - 1));
                }
                return article;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

}
