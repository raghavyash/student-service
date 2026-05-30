package com.rsnvtech.erp.edu.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StudentEnrollmentModel {

    private Long id;
    private Long studentId;
    private Long classId;
    private String batchYear;
    private LocalDateTime enrollDate;
    private String status;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
