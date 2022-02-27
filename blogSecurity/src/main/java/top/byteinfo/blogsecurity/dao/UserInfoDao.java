package top.byteinfo.blogsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.byteinfo.blogsecurity.model.UserInfo;


/**
 * 用户信息
 *
 * @author yezhiqiu
 * @date 2021/08/10
 */
@Repository
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {

}
