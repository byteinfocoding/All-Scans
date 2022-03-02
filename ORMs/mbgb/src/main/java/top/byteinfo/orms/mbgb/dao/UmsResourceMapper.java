package top.byteinfo.orms.mbgb.dao;

import java.util.List;
import top.byteinfo.orms.mbgb.entity.UmsResource;

public interface UmsResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsResource record);

    UmsResource selectByPrimaryKey(Long id);

    List<UmsResource> selectAll();

    int updateByPrimaryKey(UmsResource record);
}