package com.gem.controller;

import com.gem.dto.PaginationDTO;
import com.gem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public  String index(Model model,
                         @RequestParam(name= "page",defaultValue = "1") Integer page,
                         @RequestParam(name= "size",defaultValue = "5") Integer size){
        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination",pagination);
        return "index";
    }

}
