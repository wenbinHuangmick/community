package com.gem.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @Auther: Mick
 * @Date: 2019/8/16 14:05
 * @Description:
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public  String index(){
        return "index";
    }

}
