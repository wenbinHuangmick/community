package com.gem.controller;

import com.gem.dto.QuestionDTO;
import com.gem.mapper.QuestionMapper;
import com.gem.model.Question;
import com.gem.model.User;
import com.gem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Mick
 * @Date: 2019/8/18 19:26
 * @Description:
 */
@Controller
public class PublishController {


    @Autowired
    private QuestionService questionService;

    //修改
    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,Model model){
        QuestionDTO question=questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }





    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            @RequestParam(value = "id",required = false) Integer id,
            HttpServletRequest request,
            Model model){

    //回显以及判断内容框不为空
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

       if (title==null || title ==""){
           model.addAttribute("error","标题不能为空");
           return "publish";
       }
        if (description==null || description ==""){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        if (tag==null || tag ==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }


        //验证是否登录
        User user= (User) request.getSession().getAttribute("user");
        if (user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);
        return "redirect:/";
    }





}
