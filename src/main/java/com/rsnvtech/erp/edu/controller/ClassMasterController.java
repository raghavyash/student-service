package com.rsnvtech.erp.edu.controller;

import com.rsnvtech.erp.edu.model.ClassModel;
import com.rsnvtech.erp.edu.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/master/class")
public class ClassMasterController {


    @Autowired
    private ClassService classService;

    @PostMapping({"/save"})
    public ResponseEntity<String> saveCategory(@RequestBody ClassModel model) {
        Boolean result = this.classService.saveClasses(model);
        if (result)
            return new ResponseEntity("Successfully Save", HttpStatus.OK);
        else
            return new ResponseEntity("Not save Successfully", HttpStatus.BAD_REQUEST);
    }

    @GetMapping({"/getClassList"})
    public ResponseEntity<List<ClassModel>> getClassList() {
        List<ClassModel> classList = this.classService.getClassList();
        return new ResponseEntity(classList, HttpStatus.OK);
    }

}
