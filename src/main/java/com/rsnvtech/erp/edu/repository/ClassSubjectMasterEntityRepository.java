package com.rsnvtech.erp.edu.repository;

import com.rsnvtech.erp.edu.entity.ClassSubjectMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSubjectMasterEntityRepository extends JpaRepository<ClassSubjectMasterEntity,Long> {
}
