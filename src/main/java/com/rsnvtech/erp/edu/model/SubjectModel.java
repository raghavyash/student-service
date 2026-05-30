package com.rsnvtech.erp.edu.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class SubjectModel {
    private Integer  id;
    private String subjectName;
    private String description;
    private String subjectType;
    private LocalDateTime createDate;
    private LocalDateTime  modifiedDate;
}
