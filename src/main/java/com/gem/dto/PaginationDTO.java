package com.gem.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Mick
 * @Date: 2019/8/19 20:37
 * @Description:
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;//显示第一页
    private boolean showNext;//显示下一页
    private boolean showEndPage;//显示最后一页
    private Integer page;//当前页
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalPage,Integer page){
        this.totalPage=totalPage;
        this.page=page;

        pages.add(page);
        for (int i = 1;i <= 3;i++){
            if (page-i > 0){
                pages.add(0,page - i);
            }
            if (page + i <= totalPage){
                pages.add(page+ i);
            }

        }

         //是否展示上一页
        if(page==1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page ==totalPage){
            showNext = false;
        }else {
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }


    }

}
