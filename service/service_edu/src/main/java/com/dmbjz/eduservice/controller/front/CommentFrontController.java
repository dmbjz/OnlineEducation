package com.dmbjz.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.commonutils.JwtUtils;
import com.dmbjz.commonutils.R;
import com.dmbjz.eduservice.client.UcenterClient;
import com.dmbjz.eduservice.entity.EduComment;
import com.dmbjz.eduservice.entity.login.UcenterMember;
import com.dmbjz.eduservice.service.EduCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author dmbjz 
 * @since 2020-08-01
 */
@Api(description = "前台课程评论")
@RestController
@RequestMapping("/eduservice/comment")
public class CommentFrontController {

    @Autowired
    private EduCommentService eduCommentService;
    @Autowired
    private UcenterClient ucenterClient;

    @ApiOperation("添加评论")
    @PostMapping("/addcomment")
    public R addComment(@RequestBody EduComment comment,HttpServletRequest request) {

        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if(StringUtils.isEmpty(memberId)) {
            return R.error().code(28004).message("请登录");
        }
        System.out.println(memberId);
        comment.setMemberId(memberId);
        UcenterMember info = ucenterClient.getInfo(memberId);
        comment.setNickname(info.getNickname());
        comment.setAvatar(info.getAvatar());
        eduCommentService.save(comment);
        return R.ok();
    }

    @ApiOperation("根据课程ID获取评论并分页展示")
    @GetMapping("/commentpage/{courseId}/{index}/{limit}")
    public R pageList(@PathVariable("courseId")String courseId,@PathVariable("index")Long index,@PathVariable("limit")Long limit){
        QueryWrapper<EduComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        Page<EduComment> commentPage = new Page<>(index,limit);
        eduCommentService.page(commentPage, queryWrapper);
        List<EduComment> commentList = commentPage.getRecords();

        Map<String, Object> map = new HashMap<>();
        map.put("items", commentList);
        map.put("current", commentPage.getCurrent());
        map.put("pages", commentPage.getPages());
        map.put("size", commentPage.getSize());
        map.put("total", commentPage.getTotal());
        map.put("hasNext", commentPage.hasNext());
        map.put("hasPrevious", commentPage.hasPrevious());
        return R.ok().data(map);
    }

    @ApiOperation("根据评论ID删除评论")
    @DeleteMapping("deletecomment/{id}")
    public R deleteComment(@PathVariable("id")String commentid){
        boolean b = eduCommentService.removeById(commentid);
        if (b){
            return R.ok();
        }else{
            return R.error().message("评论删除失败");
        }
    }



}

