package top.byteinfo.mbg.dao;

import java.util.List;
import top.byteinfo.mbg.entity.UmsResource;

public interface UmsResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsResource record);

    UmsResource selectByPrimaryKey(Long id);

    List<UmsResource> selectAll();

    int updateByPrimaryKey(UmsResource record);
}