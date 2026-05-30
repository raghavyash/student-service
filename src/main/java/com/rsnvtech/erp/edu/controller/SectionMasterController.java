package com.rsnvtech.erp.edu.controller;

import com.rsnvtech.erp.edu.model.SectionModel;
import com.rsnvtech.erp.edu.model.StudentModel;
import com.rsnvtech.erp.edu.services.SectionService;
import com.rsnvtech.erp.edu.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/master/section")
public class SectionMasterController {


    @Autowired
    private SectionService sectionService;

    @PostMapping({"/save"})
    public ResponseEntity<Boolean> saveCategory(@RequestBody SectionModel model) {
        Boolean b =this.sectionService.saveSection(model);
        return new ResponseEntity(b, HttpStatus.OK);
    }

    @GetMapping({"/getSectionList"})
    public ResponseEntity<List<SectionModel>> getSectionList(@RequestBody SectionModel model) {
        List<SectionModel> result =this.sectionService.getSectionListByClassId(model.getClassId());
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
