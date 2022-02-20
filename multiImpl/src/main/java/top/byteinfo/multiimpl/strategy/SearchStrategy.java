package top.byteinfo.multiimpl.strategy;


import java.util.List;

/**
 * 搜索策略
 *
 * @author yezhiqiu
 * @date 2021/07/27
 */
public interface SearchStrategy {

    /**
     * 搜索文章
     *
     * @param keywords 关键字
     * @return {@link List<String>} 文章列表
     */
    List<String> searchArticle(String keywords);

}
