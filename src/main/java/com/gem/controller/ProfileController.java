package com.gem.controller;

import com.gem.dto.PaginationDTO;
import com.gem.model.User;
import com.gem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Mick
 * @Date: 2019/8/20 13:41
 * @Description:
 */
@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name= "page",defaultValue = "1") Integer page,
                          @RequestParam(name= "size",defaultValue = "5") Integer size){

        //如果为空，那就返回主页
        User user= (User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/";
        }

        //把数据封装传送到网页中
        if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }

        PaginationDTO paginationDTO=questionService.list(user.getId(),page,size);
        model.addAttribute("pagination",paginationDTO);
        return "profile";
    }


}
