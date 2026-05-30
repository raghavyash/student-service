package com.rsnvtech.erp.edu.repository;

import com.rsnvtech.erp.edu.entity.SubjectMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMasterEntityRepository extends JpaRepository<SubjectMasterEntity,Long> {
}
