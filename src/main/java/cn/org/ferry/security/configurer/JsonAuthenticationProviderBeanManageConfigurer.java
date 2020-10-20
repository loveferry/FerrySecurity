package cn.org.ferry.security.configurer;

import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * JSON 安全认证模式下的认证管理器注册
 * <p>
 * {@link org.springframework.security.config.annotation.authentication.configuration.InitializeAuthenticationProviderBeanManagerConfigurer}
 *
 * @author ferry
 * @date 2020-10-28 20:54
 */
@Order(JsonAuthenticationProviderBeanManageConfigurer.DEFAULT_ORDER)
public class JsonAuthenticationProviderBeanManageConfigurer extends JsonAuthenticationConfigurer {
    public static final int DEFAULT_ORDER = Ordered.LOWEST_PRECEDENCE - 20000;

    private final ApplicationContext context;

    /**
     * @param context the ApplicationContext to look up beans.
     */
    public JsonAuthenticationProviderBeanManageConfigurer(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.apply(new JsonAuthenticationProviderBeanManageConfigurer.InitializeUserDetailsManagerConfigurer());
    }

    class InitializeUserDetailsManagerConfigurer extends JsonAuthenticationConfigurer {
        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            if (auth.isConfigured()) {
                return;
            }
            AuthenticationProvider authenticationProvider = getBeanOrNull(AuthenticationProvider.class);
            if (authenticationProvider == null) {
                return;
            }
            auth.authenticationProvider(authenticationProvider);
        }

        /**
         * @return
         */
        private <T> T getBeanOrNull(Class<T> type) {
            String[] userDetailsBeanNames =
                    JsonAuthenticationProviderBeanManageConfigurer.this.context.getBeanNamesForType(type);
            if (userDetailsBeanNames.length != 1) {
                return null;
            }
            return JsonAuthenticationProviderBeanManageConfigurer.this.context.getBean(userDetailsBeanNames[0], type);
        }
    }
}
