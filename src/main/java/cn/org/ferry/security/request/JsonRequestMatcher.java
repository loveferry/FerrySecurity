package cn.org.ferry.security.request;

import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * <p> 请求匹配
 * 用来匹配Json数据登录的请求
 *
 * @author ferry ferry_sy@163.com
 * created by 2020/06/29 15:42
 */
public class JsonRequestMatcher extends AbstractRequestMatcher {
    public JsonRequestMatcher() {
        super(new AndRequestMatcher(
                new AntPathRequestMatcher("/api/**")
        ));
    }
}
