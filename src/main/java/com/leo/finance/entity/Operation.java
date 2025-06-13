package com.leo.finance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "operation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    private LocalDateTime modified;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    private String description;

    @Column(nullable = false)
    private BigDecimal value;

    @PrePersist
    public void onCreate() {
        created = LocalDateTime.now();
        modified = created;
    }

    @PreUpdate
    public void onUpdate() {
        modified = LocalDateTime.now();
    }
}
