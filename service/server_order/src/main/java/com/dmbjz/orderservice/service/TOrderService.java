package com.dmbjz.orderservice.service;

import com.dmbjz.orderservice.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author dmbjz 
 * @since 2020-08-01
 */
public interface TOrderService extends IService<TOrder> {

    String creareOrder(String courseId, String token);
}
