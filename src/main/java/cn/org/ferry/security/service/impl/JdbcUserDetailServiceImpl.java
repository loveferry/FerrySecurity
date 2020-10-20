package cn.org.ferry.security.service.impl;

import cn.org.ferry.security.service.JdbcUserDetailService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 数据库用户数据实现层
 *
 * @author ferry
 * @date 2020-10-25 17:53
 */
@Service("jdbcUserDetailService")
public class JdbcUserDetailServiceImpl implements JdbcUserDetailService {
    /**
     * 此jdbc暂时写死数据，待公共模块完成后再实现
     *
     * @param username 用户名
     * @return 用户信息
     * @throws UsernameNotFoundException 用户未找到异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder()
                .username("love")
                .password("{noop}love")
                .roles("admin")
                .build();
    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
