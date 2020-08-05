package com.dmbjz.orderservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dmbjz.commonutils.JwtUtils;
import com.dmbjz.commonutils.R;
import com.dmbjz.orderservice.entity.TOrder;
import com.dmbjz.orderservice.service.TOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author dmbjz 
 * @since 2020-08-01
 */
@RestController
@RequestMapping("/orderservice/order")
public class TOrderController {

    @Autowired
    private TOrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping("createorder/{courseId}")
    public R saveOrder(@PathVariable("courseId")String courseId,HttpServletRequest request){
        String token = JwtUtils.getMemberIdByJwtToken(request);
        if(StringUtils.isEmpty(token)){
            return R.error().message("请先登录");
        }
        String orderNum = orderService.creareOrder(courseId,token);
        return R.ok().data("orderId",orderNum);
    }

    @ApiOperation("查询订单结算详情页")
    @GetMapping("getorderInfo/{orderId}")
    public R getOrderInfo(@PathVariable("orderId") String orderId){
        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_no",orderId);
        TOrder one = orderService.getOne(queryWrapper);
        return R.ok().data("item",one);
    }

    @ApiOperation("课程详情页查询订单购买情况")
    @GetMapping("isBuyCourse/{courseId}/{userId}")
    public boolean isbycourse(@PathVariable("courseId")String courseId,@PathVariable("userId")String userId){
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.eq("member_id",userId);
        wrapper.eq("status",1);
        int count = orderService.count(wrapper);
        return count>0;
    }


}

