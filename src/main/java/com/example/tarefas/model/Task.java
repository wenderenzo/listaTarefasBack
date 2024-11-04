package com.example.tarefas.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tarefas", uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;

    @Column(name = "data_limite", nullable = false)
    private LocalDate dueDate;

    @Column(name = "ordem_apresentacao", nullable = false)
    private Integer displayOrder;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }


    // Construtores

    public Task(Long id, String name, BigDecimal cost, LocalDate dueDate, Integer displayOrder) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.dueDate = dueDate;
        this.displayOrder = displayOrder;
    }

    public Task() {
    }

    // toString

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", dueDate=" + dueDate +
                ", displayOrder=" + displayOrder +
                '}';
    }
}
