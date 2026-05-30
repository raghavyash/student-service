package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.entity.StudentEntity;
import com.rsnvtech.erp.edu.model.StudentModel;

import java.util.List;

public interface StudentService {
    StudentEntity saveStudent(StudentModel studentModel);
    Boolean updateStudent(StudentModel studentModel);
    Boolean deleteStudent(StudentModel studentModel);
    StudentModel getStudentDetail(Long studentId);
    List<StudentModel> getStudentDetailList(StudentModel studentModel);
    List<StudentModel> searchStudentDetailList(StudentModel studentModel);
}
