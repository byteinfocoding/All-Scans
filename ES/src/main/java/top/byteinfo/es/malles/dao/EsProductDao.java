package top.byteinfo.es.malles.dao;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;
import top.byteinfo.es.malles.domain.EsProduct;

import java.util.List;

/**
 * 搜索商品管理自定义Dao
 * Created by macro on 2018/6/19.
 */
@Repository
public interface EsProductDao {
    /**
     * 获取指定ID的搜索商品
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
