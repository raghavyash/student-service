package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.model.ClassModel;

import java.util.List;

public interface ClassService {
    Boolean saveClasses(ClassModel model);
    List<ClassModel> getClassList() ;
}
