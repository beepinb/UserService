package com.example.userservice.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
public class OrderCourierStatus {
    private Long id;
    private OrderStatus status;
    private LocalDate statusDate;

}
