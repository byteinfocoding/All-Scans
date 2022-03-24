package com.example.oauthclient.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.oauthclient.model.UserRole;
import org.springframework.stereotype.Repository;


/**
 * 用户角色
 *
 * @author yezhiqiu
 * @date 2021/08/10
 */
@Repository
public interface UserRoleDao extends BaseMapper<UserRole> {

}
