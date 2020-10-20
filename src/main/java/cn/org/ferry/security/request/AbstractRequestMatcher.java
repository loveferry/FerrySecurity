package cn.org.ferry.security.request;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 抽象请求匹配
 * 服务对请求匹配器的抽象，添加一个适配器属性，其实现类通过对适配器赋值完成请求匹配功能
 * 建议实现类在构造器中对适配器进行初始化
 *
 * @author ferry ferry_sy@163.com
 * created by 2020/10/20 20:57
 */
public abstract class AbstractRequestMatcher implements RequestMatcher {
    /**
     * 适配器对象
     */
    protected RequestMatcher delegator;

    public AbstractRequestMatcher(RequestMatcher requestMatcher) {
        this.delegator = requestMatcher;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return delegator.matches(request);
    }
}
