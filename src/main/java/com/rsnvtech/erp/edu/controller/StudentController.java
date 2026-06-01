package com.rsnvtech.erp.edu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsnvtech.erp.edu.config.KafkaProducerService;
import com.rsnvtech.erp.edu.entity.StudentEntity;
import com.rsnvtech.erp.edu.model.StudentModel;
import com.rsnvtech.erp.edu.pdf.PdfGeneratorStudentService;
import com.rsnvtech.erp.edu.services.StudentLoginService;
import com.rsnvtech.erp.edu.services.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
@Slf4j

public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentLoginService studentLoginService;
    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PdfGeneratorStudentService pdfGeneratorStudentService;

    @PostMapping({"/save"})
    public ResponseEntity<Boolean> saveStudentDetail(@RequestBody StudentModel model) throws JsonProcessingException {
        log.info(" Save Student Details Started {} ",model);
        StudentEntity studentEntity = this.studentService.saveStudent(model);
        log.info(" Successfully Save Student Details ");
        if(studentEntity!= null) {
            log.info(" Login Credentials Student Started ");
          boolean loginResult=  studentLoginService.saveStudentLoginCredentials(studentEntity,model);
            log.info(" Login Credentials Student Completed {}",loginResult);
            kafkaProducerService.sendMessage(objectMapper.writeValueAsString(model));
            log.info(" Successfully sent Message To User ");
            return new ResponseEntity<>(loginResult, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // PATCH method for partial update
    @PatchMapping("/update")
    public ResponseEntity<Boolean> updateMobileNumber(
            @RequestBody StudentModel model) {

        Boolean updatedUser = studentService.updateStudent(model);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteStudent(
            @RequestBody StudentModel model) {

        Boolean updatedUser = studentService.deleteStudent(model);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/getStudentDetail/{studentId}")
    public ResponseEntity<StudentModel> getStudentDetail(
            @PathVariable("studentId") Long studentId) {
        StudentModel studentModel = studentService.getStudentDetail(studentId);
        return ResponseEntity.ok(studentModel);
    }

    @GetMapping("/getStudentList")
    public ResponseEntity<List<StudentModel>> getStudentList(
            @RequestBody StudentModel model) {
        List<StudentModel> studentModel = studentService.getStudentDetailList(model);
        return ResponseEntity.ok(studentModel);
    }

    @GetMapping("/searchStudentInfo")
    public ResponseEntity<List<StudentModel>> searchStudentInfo(
            @RequestBody StudentModel model) {
        List<StudentModel> studentModel = studentService.searchStudentDetailList(model);
        return ResponseEntity.ok(studentModel);
    }

}


/*
http://localhost:8092/v1/student/save
* {
    "studentName":"Raghav",
    "parentName":"a",
    "mobileNumber":"8827704590",
    "address":"pune"

}*/