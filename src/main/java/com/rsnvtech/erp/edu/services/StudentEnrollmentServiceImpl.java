package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.constants.StudentStatus;
import com.rsnvtech.erp.edu.entity.ClassMasterEntity;
import com.rsnvtech.erp.edu.entity.StudentEnrollmentEntity;
import com.rsnvtech.erp.edu.entity.StudentEntity;
import com.rsnvtech.erp.edu.model.StudentEnrollmentModel;
import com.rsnvtech.erp.edu.repository.ClassMasterEntityRepository;
import com.rsnvtech.erp.edu.repository.StudentEnrollmentEntityRepository;
import com.rsnvtech.erp.edu.repository.StudentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class StudentEnrollmentServiceImpl implements StudentEnrollmentService {
    @Autowired
    private StudentEnrollmentEntityRepository studentEnrollmentEntityRepository;
    @Autowired
    private ClassMasterEntityRepository classMasterEntityRepository;
    @Autowired
    private StudentEntityRepository studentEntityRepository;

    @Override
    public Boolean saveStudentEnrollment(StudentEnrollmentModel model) {
        boolean validate = validateStudentEnrollment(model);
        if (validate) {
            StudentEntity studentEntity = null;
            ClassMasterEntity classMasterEntity = null;
            StudentEnrollmentEntity studentEnrollmentEntity = new StudentEnrollmentEntity();
            Optional<StudentEntity> entity = studentEntityRepository.findById(model.getStudentId());
            if (entity.isPresent()) {
                studentEntity = entity.get();
            }

            Optional<ClassMasterEntity> classMasterEntity1 = classMasterEntityRepository.findById(model.getClassId());
            if (classMasterEntity1.isPresent()) {
                classMasterEntity = classMasterEntity1.get();
            }
            studentEnrollmentEntity.setEnrollDate(model.getEnrollDate());
            studentEnrollmentEntity.setBatchYear(model.getBatchYear());
            studentEnrollmentEntity.setStatus(StudentStatus.Active.name());
            studentEnrollmentEntity.setCreateDate(LocalDateTime.now());
            studentEnrollmentEntity.setModifiedDate(LocalDateTime.now());
            studentEnrollmentEntity.setStudent(studentEntity);
            studentEnrollmentEntity.setClassMaster(classMasterEntity);
            studentEnrollmentEntityRepository.saveAndFlush(studentEnrollmentEntity);
            return null;
        }
        return null;
    }

    private boolean validateStudentEnrollment(StudentEnrollmentModel model) {
        StudentEnrollmentEntity studentEnrollmentEntity = null;
        Optional<StudentEnrollmentEntity> entity = studentEnrollmentEntityRepository.findById(model.getId());
        if (entity.isPresent()) {
            studentEnrollmentEntity = entity.get();
        }
        Long UserId = model.getStudentId();
        Long classId = model.getClassId();
        assert studentEnrollmentEntity != null;
        if (studentEnrollmentEntity.getStudent().getStudentId().equals(UserId)) {
            return true;
        }
        if (studentEnrollmentEntity.getClassMaster().getId().equals(classId)) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateStudentEnrollment(StudentEnrollmentModel model) {
        boolean validate = validateStudentEnrollment(model);
        if (validate) {
            StudentEnrollmentEntity studentEnrollmentEntity = null;
            Optional<StudentEnrollmentEntity> entity = studentEnrollmentEntityRepository.findById(model.getId());
            if (entity.isPresent()) {
                studentEnrollmentEntity = entity.get();
                if (model.getEnrollDate() != null) {
                    studentEnrollmentEntity.setEnrollDate(model.getEnrollDate());
                }
                if (model.getBatchYear() != null) {
                    studentEnrollmentEntity.setBatchYear(model.getBatchYear());
                }
                if (model.getStatus() != null) {
                    studentEnrollmentEntity.setStatus(model.getStatus());
                }
                studentEnrollmentEntityRepository.saveAndFlush(studentEnrollmentEntity);
                return true;
            }
        }
        return false;
    }
}
