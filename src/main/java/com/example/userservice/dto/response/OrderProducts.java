package com.example.userservice.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
public class OrderProducts {
    private Long id;
    private Long product_id;
    private Integer quantity;
}
