package com.dmbjz.orderservice.service.impl;

import com.dmbjz.commonutils.order.CourseWebVoOrder;
import com.dmbjz.orderservice.client.OrderCourseClient;
import com.dmbjz.orderservice.client.OrderInfoClient;
import com.dmbjz.orderservice.entity.TOrder;
import com.dmbjz.orderservice.entity.order.UcenterMember;
import com.dmbjz.orderservice.mapper.TOrderMapper;
import com.dmbjz.orderservice.service.TOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmbjz.orderservice.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author dmbjz
 * @since 2020-08-01
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Autowired
    private OrderInfoClient userinfo;
    @Autowired
    private OrderCourseClient courseinfo;

    @Override
    public String creareOrder(String courseId, String token) {
        //远程调用获取用户信息和课程信息
        UcenterMember info = userinfo.getInfo(token);
        CourseWebVoOrder order = courseinfo.getcoursebyId(courseId);
        //创建Order对象
        TOrder tOrder =new TOrder();
        //生成订单号并设置
        String orderNo = OrderNoUtil.getOrderNo();
        tOrder.setOrderNo(orderNo);
        //保存
        tOrder.setCourseId(courseId);
        tOrder.setCourseTitle(order.getTitle());
        tOrder.setCourseCover(order.getCover());
        tOrder.setTeacherName("test");
        tOrder.setTotalFee(order.getPrice());
        tOrder.setMemberId(token);
        tOrder.setMobile(info.getMobile());
        tOrder.setNickname(info.getNickname());
        //设置支付状态和支付渠道
        tOrder.setStatus(0);
        tOrder.setPayType(1);
        baseMapper.insert(tOrder);
        //返回订单号
        return tOrder.getOrderNo();
    }


}
