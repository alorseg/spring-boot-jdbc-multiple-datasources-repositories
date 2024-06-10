package com.example.multisourcerepositoryapp.bar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_grades")
@EqualsAndHashCode(callSuper = false)
public class BarEntity {
    @Id
    private Integer grade_id;
    private String grade_name;
}
