package com.rsnvtech.erp.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "subject_master")
public class SubjectMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long  id;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SUBJECT_TYPE")
    private String subjectType;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime  modifiedDate;
}
