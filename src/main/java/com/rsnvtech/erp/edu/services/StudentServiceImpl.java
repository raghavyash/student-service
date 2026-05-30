package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.constants.StatusFields;
import com.rsnvtech.erp.edu.entity.StudentEntity;
import com.rsnvtech.erp.edu.model.StudentModel;
import com.rsnvtech.erp.edu.repository.StudentEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentEntityRepository studentEntityRepository;

    @Override
    @CachePut(value = "studentCache", key = "#a0")
    public StudentEntity saveStudent(StudentModel model) {
        log.info("Save Student Detail Data");
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(model, studentEntity);
        return studentEntityRepository.save(studentEntity);
    }

    @Override
    @CachePut(value = "studentCache", key = "#a0")
    public Boolean updateStudent(StudentModel model) {
        log.info("Update Student Detail data");
        StudentEntity studentEntity = null;
        if (model != null) {
            Optional<StudentEntity> entity = studentEntityRepository.findById(model.getStudentId());
            if (entity.isPresent()) {
                studentEntity = entity.get();
            }
            updateStudentProfile(model, studentEntity);
            studentEntityRepository.saveAndFlush(studentEntity);
        }
        return true;
    }

    private void updateStudentProfile(StudentModel model, StudentEntity studentEntity) {
        if (model.getEmail() != null) {
            studentEntity.setEmail(model.getEmail());
        }
        if (model.getStudentName() != null) {
            studentEntity.setStudentName(model.getStudentName());
        }
        if (model.getAddress() != null) {
            studentEntity.setAddress(model.getAddress());
        }
        if (model.getMobileNumber() != null) {
            studentEntity.setMobileNumber(model.getMobileNumber());
        }
    }

    @Override
    public Boolean deleteStudent(StudentModel model) {
        StudentEntity studentEntity = null;
        if (model != null) {
            Optional<StudentEntity> entity = studentEntityRepository.findById(model.getStudentId());
            if (entity.isPresent()) {
                studentEntity = entity.get();
            }

            studentEntity.setStatus(StatusFields.INACTIVE.name());

            studentEntityRepository.saveAndFlush(studentEntity);
        }
        return true;
    }

    @Override
    @Cacheable(value = "userCache", key = "#studentId")
    public StudentModel getStudentDetail(Long studentId) {
        log.info("Get Student Detail data");
        StudentEntity studentEntity = null;
        StudentModel model = new StudentModel();
        Optional<StudentEntity> entity = studentEntityRepository.findById(studentId);
        if (entity.isPresent()) {
            studentEntity = entity.get();
        }
        if (studentEntity != null) {
            BeanUtils.copyProperties(studentEntity, model);
        }
        return model;
    }

    @Override
    public List<StudentModel> getStudentDetailList(StudentModel studentModel) {
        List<StudentEntity> list = studentEntityRepository.findAll();
        return list.stream()
                .map(entity -> {
                    StudentModel model = new StudentModel();
                    BeanUtils.copyProperties(entity, model);
                    return model;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentModel> searchStudentDetailList(StudentModel model) {
        List<StudentEntity> list = studentEntityRepository.findByStudentNameOrMobileNumber(model.getStudentName(), model.getMobileNumber());
        List<StudentModel> studentList = list.stream()
                .map(entity -> {
                    StudentModel studentModel = new StudentModel();
                    BeanUtils.copyProperties(entity, studentModel);
                    return studentModel;
                })
                .collect(Collectors.toList());
        return studentList;
    }
}
