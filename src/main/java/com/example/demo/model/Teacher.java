package com.example.demo.model;

import com.example.demo.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Teacher")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Teacher {
    @Id
    private String email;
    private String name;
    private String password;
    private String specialization;

   @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "email")
    private User user;



}
