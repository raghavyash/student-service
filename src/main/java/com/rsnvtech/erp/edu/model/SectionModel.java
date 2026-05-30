package com.rsnvtech.erp.edu.model;

import com.rsnvtech.erp.edu.entity.ClassMasterEntity;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class SectionModel {
    private Long  id;
    private String sectionName;
    private Long classId;
    private LocalDateTime createDate;
    private LocalDateTime  modifiedDate;
}
