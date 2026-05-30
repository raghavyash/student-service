package com.rsnvtech.erp.edu.model;


import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class StudentModel {
    private Long   studentId;
    private String   studentName;
    private String parentName;
    private String motherName;
    private LocalDateTime dob;
    private Integer age;
    private String rollNumber;
    private String gender;
    private String govId;
    private String phoneNumber;
    private String mobileNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private Integer postalCode;
    private String country;
    private String parentEmail;

    private String description;

    private LocalDateTime createDate;

    private LocalDateTime  modifiedDate;
}
