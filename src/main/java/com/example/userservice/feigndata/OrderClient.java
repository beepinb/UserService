package com.example.userservice.feigndata;

import com.example.userservice.dto.response.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order")
public interface OrderClient {

    @GetMapping("/order/user/{userId}")
    List<Order> getOrder(@PathVariable Long userId);
}
