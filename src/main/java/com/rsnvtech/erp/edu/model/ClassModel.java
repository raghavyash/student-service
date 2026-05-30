package com.rsnvtech.erp.edu.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class ClassModel {
    private Integer  id;
    private String className;
    private String printName;
    private LocalDateTime createDate;
    private LocalDateTime  modifiedDate;
}
