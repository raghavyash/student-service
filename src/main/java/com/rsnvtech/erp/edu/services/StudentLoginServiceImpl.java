package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.constants.StudentStatus;
import com.rsnvtech.erp.edu.entity.StudentEntity;
import com.rsnvtech.erp.edu.entity.StudentLoginEntity;
import com.rsnvtech.erp.edu.model.StudentLoginModel;
import com.rsnvtech.erp.edu.model.StudentModel;
import com.rsnvtech.erp.edu.repository.StudentLoginRepository;
import com.rsnvtech.erp.edu.util.StudentUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {

    @Autowired
    private StudentLoginRepository studentLoginRepository;

    @Transactional
    @Override
    public boolean saveStudentLoginCredentials(StudentEntity studentEntity,StudentModel model) {
        StudentLoginEntity studentLoginEntity = new StudentLoginEntity();
        if (model.getEmail() == null) {
            model.setEmail(model.getStudentName().substring(0, 6) + model.getMobileNumber().substring(6, 10) + "@gmail.com");
        }
        studentLoginEntity.setEmail(model.getEmail());
        studentLoginEntity.setPassword(StudentUtil.generatePassword(6));
        studentLoginEntity.setStatus(StudentStatus.Active.name());
        studentLoginEntity.setCreateDate(LocalDateTime.now());
        studentLoginEntity.setModifiedDate(LocalDateTime.now());

        studentLoginEntity.setStudent(studentEntity);
        studentLoginRepository.save(studentLoginEntity);
        return true;
    }
}
