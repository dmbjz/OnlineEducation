package com.dmbjz.eduservice.entity.vo;

import lombok.Data;

@Data
public class CoursePublishVo {

    private String id;
    private String title;
    private String cover;
    private String description;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示

}
