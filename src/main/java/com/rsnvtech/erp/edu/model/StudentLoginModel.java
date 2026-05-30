package com.rsnvtech.erp.edu.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentLoginModel {
    private Long   id;
    private Long   studentId;
    private String   email;
    private String password;
    private String   status;
}
