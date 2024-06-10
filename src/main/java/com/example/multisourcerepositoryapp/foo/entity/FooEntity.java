package com.example.multisourcerepositoryapp.foo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
public class FooEntity {
    @Id
    private UUID user_id;
    private String username;
    private String password;
    private String email;
}
