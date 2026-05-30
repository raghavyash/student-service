package com.rsnvtech.erp.edu.controller;

import com.rsnvtech.erp.edu.model.StudentModel;
import com.rsnvtech.erp.edu.model.SubjectModel;
import com.rsnvtech.erp.edu.services.StudentService;
import com.rsnvtech.erp.edu.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/master/subject")
public class SubjectMasterController {


    @Autowired
    private SubjectService subjectService;

    @PostMapping({"/save"})
    public ResponseEntity<Boolean> saveCategory(@RequestBody SubjectModel model) {
        Boolean b =this.subjectService.saveSubject(model);
        return new ResponseEntity(b, HttpStatus.OK);
    }
}
