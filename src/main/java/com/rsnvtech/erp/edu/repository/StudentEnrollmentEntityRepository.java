package com.rsnvtech.erp.edu.repository;

import com.rsnvtech.erp.edu.entity.StudentEnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollmentEntityRepository extends JpaRepository<StudentEnrollmentEntity,Long> {
}
