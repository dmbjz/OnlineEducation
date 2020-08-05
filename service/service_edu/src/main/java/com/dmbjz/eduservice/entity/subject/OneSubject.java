package com.dmbjz.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OneSubject {

    private String id;
    private String title;

    //一个一级分类有对应多个二级分类
    private List<TwoSubject> child = new ArrayList<>();

}
