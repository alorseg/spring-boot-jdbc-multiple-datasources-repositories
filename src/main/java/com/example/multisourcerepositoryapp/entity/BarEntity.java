package com.example.multisourcerepositoryapp.entity;

import com.example.multisourcerepositoryapp.persistence.AbstractAuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "user_grades")
@EqualsAndHashCode(callSuper = false)
public class BarEntity extends AbstractAuditableEntity {
    @Id
    private Integer grade_id;
    private String grade_name;
    private LocalDate createdOn;
    private LocalDate lastUpdated;
    private String createdBy;
    private String lastModifiedBy;
}
