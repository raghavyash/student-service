package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.entity.StudentEntity;
import com.rsnvtech.erp.edu.model.StudentLoginModel;
import com.rsnvtech.erp.edu.model.StudentModel;

public interface StudentLoginService {

    boolean saveStudentLoginCredentials(StudentEntity entity,StudentModel studentModel);
}
