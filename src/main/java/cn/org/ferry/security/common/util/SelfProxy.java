package cn.org.ferry.security.common.util;

import org.springframework.aop.framework.AopContext;

/**
 * 代理自身，实现此接口的实现类通过 self 方法调用本身的 public 方法，使得方法支持事务
 *
 * @author ferry
 * @date 2020-10-25 17:47
 */
public interface SelfProxy<T> {
    /**
     * 使方法调用者获取当前bean的代理类
     *
     * @param <T> 真实对象的类型
     * @return 代理对象
     */
    default <T> T self() {
        return (T) AopContext.currentProxy();
    }
}
