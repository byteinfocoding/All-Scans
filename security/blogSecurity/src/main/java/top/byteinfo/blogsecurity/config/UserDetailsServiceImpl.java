package top.byteinfo.blogsecurity.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import top.byteinfo.blogsecurity.dao.RoleDao;
import top.byteinfo.blogsecurity.dao.UserAuthDao;
import top.byteinfo.blogsecurity.dao.UserInfoDao;
import top.byteinfo.blogsecurity.model.UserAuth;
import top.byteinfo.blogsecurity.model.UserInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static top.byteinfo.blogsecurity.model.ZoneEnum.SHANGHAI;


/**
 * 用户详细信息服务
 *
 * @author yezhiqiu
 * @date 2021/08/10
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserAuthDao userAuthDao;//tb_user_auth
    @Autowired
    private UserInfoDao userInfoDao;//tb_user_info
    @Autowired
    private RoleDao roleDao;//tb_role
    //    @Autowired
//    private RedisService redisService;
    @Resource
    private HttpServletRequest request;
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("用户名不能为空！");
        }
        // 查询账号是否存在
        UserAuth userAuth = userAuthDao.selectOne(
                new LambdaQueryWrapper<UserAuth>()
                        .select(UserAuth::getId, UserAuth::getUserInfoId, UserAuth::getUsername, UserAuth::getPassword, UserAuth::getLoginType)
                        .eq(UserAuth::getUsername, username));
        if (Objects.isNull(userAuth)) {
            throw new RuntimeException("用户名不存在!");
        }
        // 封装登录信息
        return convertUserDetail(userAuth, request);
    }

    /**
     * 封装用户登录信息
     *
     * @param user    用户账号
     * @param request 请求
     * @return 用户登录信息
     */
    public UserDetailDTO convertUserDetail(UserAuth user, HttpServletRequest request) {

        // 查询账号信息
        UserInfo userInfo = userInfoDao.selectById(user.getUserInfoId());
        // 查询账号角色
        List<String> roleList = roleDao.listRolesByUserInfoId(userInfo.getId());
        // 查询账号点赞信息
//        Set<Object> articleLikeSet = redisService.sMembers(ARTICLE_USER_LIKE + userInfo.getId());
//        Set<Object> articleLikeSet = redisTemplate.opsForSet().members(ARTICLE_USER_LIKE + userInfo.getId());
        Set<Object> articleLikeSet = new HashSet<>();
        articleLikeSet.add("articleLikeSet");
//        Set<Object> commentLikeSet = redisService.sMembers(COMMENT_USER_LIKE + userInfo.getId());
//        Set<Object> commentLikeSet = redisTemplate.opsForSet().members(COMMENT_USER_LIKE + userInfo.getId());
        Set<Object> commentLikeSet = new HashSet<>();
        commentLikeSet.add("Set<Object> commentLikeSet =");
        // 获取设备信息
//        String ipAddress = IpUtils.getIpAddress(request);
//        String ipSource = IpUtils.getIpSource(ipAddress);
//        UserAgent userAgent = IpUtils.getUserAgent(request);

        // 封装权限集合
        return UserDetailDTO.builder()
                .id(user.getId())
                .loginType(user.getLoginType())
                .userInfoId(userInfo.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(userInfo.getEmail())
                .roleList(roleList)
                .nickname(userInfo.getNickname())
                .avatar(userInfo.getAvatar())
                .intro(userInfo.getIntro())
                .webSite(userInfo.getWebSite())
                .articleLikeSet(articleLikeSet)
                .commentLikeSet(commentLikeSet)
                .ipAddress("ipAddress")
                .ipSource("ipSource")
                .isDisable(userInfo.getIsDisable())
                .browser("userAgent.getBrowser().getName()")
                .os("userAgent.getOperatingSystem().getName()")
                .lastLoginTime(LocalDateTime.now(ZoneId.of(SHANGHAI.getZone())).toString())
                .build();
    }

}
