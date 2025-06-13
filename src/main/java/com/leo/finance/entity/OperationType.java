package com.leo.finance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "operationtype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
