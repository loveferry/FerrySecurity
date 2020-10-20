package cn.org.ferry.security.config;

import cn.org.ferry.security.request.BasicRequestMatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * <p> 安全配置
 * 基于Form表单的登录
 *
 * @author ferry ferry_sy@163.com
 * created by 2020/06/29 15:42
 */
@Configuration
@EnableWebSecurity
@Slf4j
@Order
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 密码默认前缀
     */
    private static final String NOOP_PASSWORD_PREFIX = "{noop}";

    /**
     * 密码匹配正则表达式
     */
    private static final Pattern PASSWORD_ALGORITHM_PATTERN = Pattern.compile("^\\{.+}.*$");

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    /**
     * 使用默认的 HttpSecurity 配置
     */
    public BasicSecurityConfiguration() {
        super(false);
    }

    /**
     * 基于内存的用户管理
     *
     * @param properties      用户信息
     * @param passwordEncoder 解码器
     * @return 用户管理组件
     */
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(
            SecurityProperties properties,
            ObjectProvider<PasswordEncoder> passwordEncoder) {
        SecurityProperties.User user = properties.getUser();
        List<String> roles = user.getRoles();
        return new InMemoryUserDetailsManager(User.withUsername(user.getName())
                .password(getOrDeducePassword(user, passwordEncoder.getIfAvailable()))
                .roles(StringUtils.toStringArray(roles)).build());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatcher(new BasicRequestMatcher())
                .authorizeRequests().anyRequest().authenticated().and()
                .formLogin().and()
                .userDetailsService(inMemoryUserDetailsManager)
                .httpBasic();
    }

    /**
     * 获取密码
     *
     * @param user    用户信息
     * @param encoder 解码器
     * @return 密码
     */
    private String getOrDeducePassword(SecurityProperties.User user, PasswordEncoder encoder) {
        String password = user.getPassword();
        if (user.isPasswordGenerated()) {
            log.info(String.format("%n%nUsing generated security password: %s%n", user.getPassword()));
        }
        if (encoder != null || PASSWORD_ALGORITHM_PATTERN.matcher(password).matches()) {
            return password;
        }
        return NOOP_PASSWORD_PREFIX + password;
    }
}
