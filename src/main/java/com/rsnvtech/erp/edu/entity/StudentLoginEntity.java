package com.rsnvtech.erp.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "student_login")
public class StudentLoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long   id;
    @ManyToOne(fetch = FetchType.LAZY) // Many orders belong to one user
    @JoinColumn(name = "STUDENT_ID") // Specifies the foreign key column in the 'orders' table
    private StudentEntity student;

    @Column(name = "EMAIL")
    private String   email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private String   status;
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime  modifiedDate;

}
