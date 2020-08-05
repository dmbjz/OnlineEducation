package com.dmbjz.eduservice.entity.chapter;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVo {

    private String id;
    private String title;
    //章节里的小节
    private List<VideoVo> child = new ArrayList<>();

}
