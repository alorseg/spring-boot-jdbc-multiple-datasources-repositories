package com.example.multisourcerepositoryapp.entity;

import com.example.multisourcerepositoryapp.persistence.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
public class FooEntity extends AbstractAuditableEntity {
    @Id
    private UUID user_id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime created_at;
}
