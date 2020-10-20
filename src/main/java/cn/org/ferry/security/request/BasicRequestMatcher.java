package cn.org.ferry.security.request;

import org.springframework.security.web.util.matcher.AnyRequestMatcher;

/**
 * <p> 请求匹配
 * 基本的请求匹配，所有的非模块化定制的请求都将匹配该类，其对应的配置类应该优先级最低，只有匹配不到其他的情况下才会走这个
 *
 * @author ferry ferry_sy@163.com
 * created by 2020/06/29 15:42
 */
public class BasicRequestMatcher extends AbstractRequestMatcher {
    public BasicRequestMatcher() {
        super(AnyRequestMatcher.INSTANCE);
    }
}
