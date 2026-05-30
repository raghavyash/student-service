package com.rsnvtech.erp.edu.controller;

import com.rsnvtech.erp.edu.model.StudentModel;
import com.rsnvtech.erp.edu.services.StudentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/student/login")
public class StudentLoginController {

    @Autowired
    private StudentLoginService studentLoginService;
    @GetMapping("/login")
    public ResponseEntity<Boolean> checkLoginDetails(
            @RequestBody StudentModel model) {
        return ResponseEntity.ok(true);
    }
}
