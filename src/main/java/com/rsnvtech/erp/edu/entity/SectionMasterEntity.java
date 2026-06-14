package com.rsnvtech.erp.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "section_master")
public class SectionMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long  id;

    @Column(name = "SECTION_NAME")
    private String sectionName;

    @ManyToOne(fetch = FetchType.LAZY) // Many orders belong to one user
    @JoinColumn(name = "CLASS_ID") // Specifies the foreign key column in the 'orders' table
    private ClassMasterEntity classMaster;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime  modifiedDate;
}
