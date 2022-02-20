package top.byteinfo.mbg.dao;

import java.util.List;
import top.byteinfo.mbg.entity.UmsAdmin;

public interface UmsAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    List<UmsAdmin> selectAll();

    int updateByPrimaryKey(UmsAdmin record);
}