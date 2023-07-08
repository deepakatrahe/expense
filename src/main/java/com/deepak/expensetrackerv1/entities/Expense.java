package com.deepak.expensetrackerv1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
@Data
@AllArgsConstructor
@Entity
@Table(name="tbl_expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="expense_name")
    @NotNull("Expense name cannot be null")
    @Size(min=3 , max=50, message = "Expense name must be between 3 to 50 characters")
    private String name;


    private String description;

    @Column(name="expense_amount")
    private BigDecimal amount;

    private String category;

    private Date date;

    @Column(name="created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    @CreationTimestamp
    private Timestamp updatedAt;

    public Expense() {
    }
}
