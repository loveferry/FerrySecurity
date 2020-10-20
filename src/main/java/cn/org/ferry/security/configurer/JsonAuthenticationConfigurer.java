package cn.org.ferry.security.configurer;

import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

/**
 * Json 安全配置认证配置抽象类类
 * {@link GlobalAuthenticationConfigurerAdapter}
 *
 * @author ferry
 * @date 2020-10-28 20:54
 */
@Order(100)
public abstract class JsonAuthenticationConfigurer implements
        SecurityConfigurer<AuthenticationManager, AuthenticationManagerBuilder> {
    @Override
    public void init(AuthenticationManagerBuilder builder) throws Exception {
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
    }
}
