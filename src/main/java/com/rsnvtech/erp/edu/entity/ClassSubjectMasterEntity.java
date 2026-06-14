package com.rsnvtech.erp.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "class_subject_master")
public class ClassSubjectMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long  id;

    @ManyToOne(fetch = FetchType.LAZY) // Many orders belong to one user
    @JoinColumn(name = "CLASS_ID") // Specifies the foreign key column in the 'orders' table
    private ClassMasterEntity classMaster;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SUBJECT_ID")
    private List<SubjectMasterEntity> subjectMaster = new ArrayList<>(); // Initialize the list here



    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime  modifiedDate;
}
