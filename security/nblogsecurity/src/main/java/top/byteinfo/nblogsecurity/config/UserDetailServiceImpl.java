package top.byteinfo.nblogsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.byteinfo.nblogsecurity.entity.User;
import top.byteinfo.nblogsecurity.mapper.UserMapper;

/**
 * @Description: 用户业务层接口实现类
 * @Author: Naccl
 * @Date: 2020-07-19
 */
@Service
public class UserDetailServiceImpl implements  UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userMapper.selectByPrimaryName(username);
		System.out.println("++++");
		if (user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		return user;
	}

//	@Override
//	public User findUserByUsernameAndPassword(String username, String password) {
//		User user = userMapper.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("用户不存在");
//		}
//		if (!HashUtils.matchBC(password, user.getPassword())) {
//			throw new UsernameNotFoundException("密码错误");
//		}
//		return user;
//	}
}
