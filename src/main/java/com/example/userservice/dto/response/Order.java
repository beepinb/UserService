package com.example.userservice.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private Long id;
    private String order_id;
    private LocalDate ordered_date;
    private Long userId;
    private List<OrderProducts> orderProducts = new ArrayList<>();
    private OrderCourierStatus orderCourierStatus;
    private List<ProductDTO> productDTOS;
}
