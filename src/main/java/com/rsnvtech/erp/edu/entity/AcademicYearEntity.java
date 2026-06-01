package com.rsnvtech.erp.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "academic_year")
public class AcademicYearEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long  id;

    @Column(name = "YEAR_NAME")
    private String yearName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "START_DATE")
    private LocalDateTime  startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime  modifiedDate;

}
