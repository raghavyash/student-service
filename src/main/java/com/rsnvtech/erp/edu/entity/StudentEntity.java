package com.rsnvtech.erp.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Long   studentId;
    @Column(name = "STUDENT_NAME")
    private String   studentName;
    @Column(name = "PARENT_NAME")
    private String parentName;
    @Column(name = "MOTHER_NAME")
    private String motherName;
    @Column(name = "DOB")
    private LocalDateTime dob;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "ROLL_NUMBER")
    private String rollNumber;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "GOV_ID")
    private String govId;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "POSTAL_CODE")
    private Integer postalCode;
    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "STATUS")
    private String status;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PARENT_EMAIL")
    private String parentEmail;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime  modifiedDate;
}
