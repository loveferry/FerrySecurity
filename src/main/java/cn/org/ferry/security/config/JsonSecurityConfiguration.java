package cn.org.ferry.security.config;

import cn.org.ferry.security.request.JsonRequestMatcher;
import cn.org.ferry.security.service.JdbcUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p> 安全配置
 * 使用JSON数据登录的配置类
 *
 * @author ferry ferry_sy@163.com
 * created by 2020/06/29 15:42
 */
@Configuration
@Slf4j
@Order(100)
public class JsonSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JdbcUserDetailService jdbcUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(jdbcUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatcher(new JsonRequestMatcher())
                .authorizeRequests().anyRequest().authenticated().and()
                .formLogin().and()
                .userDetailsService(jdbcUserDetailService)
                .httpBasic();
    }
}
