package com.gem.service;

import com.gem.dto.PaginationDTO;
import com.gem.dto.QuestionDTO;
import com.gem.mapper.QuestionMapper;
import com.gem.mapper.UserMapper;
import com.gem.model.Question;
import com.gem.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Mick
 * @Date: 2019/8/18 22:42
 * @Description:
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    //首页分页设置
    public PaginationDTO list(Integer page, Integer size){
        PaginationDTO paginationDTO=new PaginationDTO();
        Integer totalPage;

        Integer totalCount =questionMapper.count();

        if (totalCount % size==0){
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage,page);
        //分页功能
        Integer offset= size * (page-1);
        List<Question> questions=questionMapper.list(totalPage,size);
        List<QuestionDTO> questionDTOList =new ArrayList<>();

        for (Question question : questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    //个人中心页分页设置
    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO=new PaginationDTO();

        Integer totalPage;

        Integer totalCount =questionMapper.countByUserId(userId);

        if (totalCount % size==0){
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }
        if (page<1){
            page=1;
        }
        if (page > totalPage){
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage,page);

        //分页功能（size*(page-1)）
        Integer offset= size * (page-1);
        List<Question> questions = questionMapper.listByUserId(userId,offset,size);
        List<QuestionDTO> questionDTOList =new ArrayList<>();

         //循环显示列表内容
        for (Question question : questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    //问题详情页面
    public QuestionDTO getById(Integer id) {
        Question question=questionMapper.getById(3);
        QuestionDTO questionDTO=new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user=userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }
}
