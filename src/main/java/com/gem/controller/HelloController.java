package com.gem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Mick
 * @Date: 2019/8/16 14:05
 * @Description:
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public  String hello(@RequestParam(name="name") String name, Model mode){
        mode.addAttribute("name1",name);

        return "hello";
    }

}
