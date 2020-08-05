package com.dmbjz.orderservice.client;

import com.dmbjz.orderservice.client.fallback.OrderInfoClientImpl;
import com.dmbjz.orderservice.entity.order.UcenterMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "service-ucenter",fallback = OrderInfoClientImpl.class)
@Component
public interface OrderInfoClient {

    @PostMapping("/educenter/member/getInfoUc/{id}")
    public UcenterMember getInfo(@PathVariable("id") String id);

}
