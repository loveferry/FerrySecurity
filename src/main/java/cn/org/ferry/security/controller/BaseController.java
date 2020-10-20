package cn.org.ferry.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>基础控制器
 *
 * @author ferry ferry_sy@163.com
 * created by 2020/06/29 14:54
 */

@RestController
@RequestMapping("/api")
public class BaseController {

    /**
     * hello
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
