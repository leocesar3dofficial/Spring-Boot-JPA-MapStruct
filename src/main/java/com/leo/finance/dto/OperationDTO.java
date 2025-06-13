package com.leo.finance.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OperationDTO {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Long categoryId;
    private String description;
    private BigDecimal value;
}
