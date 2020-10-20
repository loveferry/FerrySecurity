package cn.org.ferry.security.service;

import cn.org.ferry.security.common.util.SelfProxy;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * 数据库用户数据获取业务接口层
 *
 * @author ferry
 * @date 2020-10-25 17:50
 */
public interface JdbcUserDetailService extends UserDetailsManager, SelfProxy<JdbcUserDetailService> {

}
