package com.dmbjz.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmbjz.commonutils.JwtUtils;
import com.dmbjz.commonutils.R;
import com.dmbjz.commonutils.order.CourseWebVoOrder;
import com.dmbjz.eduservice.client.OrderClient;
import com.dmbjz.eduservice.entity.EduCourse;
import com.dmbjz.eduservice.entity.chapter.ChapterVo;
import com.dmbjz.eduservice.entity.front.CourseFrontVo;
import com.dmbjz.eduservice.entity.front.CourseWebVo;
import com.dmbjz.eduservice.service.EduChapterService;
import com.dmbjz.eduservice.service.EduCourseService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(description = "前台课程信息")
@RestController
@RequestMapping("/eduservice/coursefront")
@DefaultProperties(defaultFallback = "CourseTimeOut")
public class CourseFrontController {

    @Autowired
    private EduCourseService eduCourseService;
    @Autowired
    private EduChapterService eduChapterService;
    @Autowired
    private OrderClient orderClient;

    @ApiOperation(value = "分页课程列表")
    @PostMapping(value = "getFrontCourselist/{index}/{limit}")
    public R pageList(@PathVariable("index")Long index, @PathVariable("limit")Long limit,@RequestBody(required = false)CourseFrontVo courseQuery){
        Page<EduCourse> pageParam = new Page<EduCourse>(index, limit);
        Map<String, Object> map = eduCourseService.getCourseFrontList(pageParam, courseQuery);
        return  R.ok().data(map);
    }

    @ApiOperation("前端课程详情")
    @GetMapping("getCourseInfo/{courseId}")
    @HystrixCommand(fallbackMethod = "courseInfoFallBackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
    })
    public R getFrontCourseInfo(@PathVariable("courseId")String courseId, HttpServletRequest request){
        //根据课程ID查询课程信息
        CourseWebVo vo = eduCourseService.getFrontCourseInfo(courseId);
        //根据课程ID查询章节和小节
        List<ChapterVo> chapterVideoList = eduChapterService.getChapterVideoByCourseId(courseId);
        //查询课程是否已被支付
        String token = JwtUtils.getMemberIdByJwtToken(request);
        boolean isbycourse = false;
        if (!StringUtils.isEmpty(token)){
            isbycourse = orderClient.isbycourse(courseId, token);
        }
        return R.ok().data("courseWebVo",vo).data("chapterVideoList",chapterVideoList).data("isBuy",isbycourse);
    }

    @ApiOperation("订单根据课程ID查询课程信息")
    @GetMapping("getCourseInfoOrder/{id}")
    public CourseWebVoOrder getcoursebyId(@PathVariable("id")String id){
        CourseWebVo frontCourseInfo = eduCourseService.getFrontCourseInfo(id);
        CourseWebVoOrder order = new CourseWebVoOrder();
        BeanUtils.copyProperties(frontCourseInfo,order);
        return order;
    }

    /*Hystrix出错兜底方法*/
    public R courseInfoFallBackMethod(@PathVariable("courseId")String courseId, HttpServletRequest request) {
        return R.error().message("请求过多访问超时，请稍后再试");
    }
    public R CourseTimeOut() {
        return R.error().message("系统访问异常，请稍后再试");
    }

}
