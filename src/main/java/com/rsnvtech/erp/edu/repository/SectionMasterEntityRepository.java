package com.rsnvtech.erp.edu.repository;

import com.rsnvtech.erp.edu.entity.ClassMasterEntity;
import com.rsnvtech.erp.edu.entity.SectionMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionMasterEntityRepository extends JpaRepository<SectionMasterEntity,Long> {
List<SectionMasterEntity> findByClassMaster(ClassMasterEntity entity);
}
