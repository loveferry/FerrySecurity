package cn.org.ferry.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>基础控制器
 *
 * @author ferry ferry_sy@163.com
 * created by 2020/06/26 12:59
 */

@RestController
public class BaseController {
    @RequestMapping("/")
    public String home(){
        return "Hello World.";
    }
}
