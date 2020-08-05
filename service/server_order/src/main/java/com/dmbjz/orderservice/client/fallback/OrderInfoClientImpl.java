package com.dmbjz.orderservice.client.fallback;

import com.dmbjz.orderservice.client.OrderInfoClient;
import com.dmbjz.orderservice.entity.order.UcenterMember;
import org.springframework.stereotype.Component;

@Component
public class OrderInfoClientImpl implements OrderInfoClient {

    @Override
    public UcenterMember getInfo(String id) {
        return null;
    }

}
