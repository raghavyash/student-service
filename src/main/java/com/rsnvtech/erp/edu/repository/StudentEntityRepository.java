package com.rsnvtech.erp.edu.repository;

import com.rsnvtech.erp.edu.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity ,Long> {
    List<StudentEntity> findByStudentNameOrMobileNumber(String name,String mobileNumber);
 }
