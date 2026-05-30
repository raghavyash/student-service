package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.entity.ClassMasterEntity;
import com.rsnvtech.erp.edu.entity.SectionMasterEntity;
import com.rsnvtech.erp.edu.model.SectionModel;
import com.rsnvtech.erp.edu.repository.ClassMasterEntityRepository;
import com.rsnvtech.erp.edu.repository.SectionMasterEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionMasterEntityRepository sectionMasterEntityRepository;
    @Autowired
    private ClassMasterEntityRepository classMasterEntityRepository;

    @Override
   // @CachePut(value = "classCache", key = "#model.id")
    public Boolean saveSection(SectionModel model) {
        ClassMasterEntity entity = null;
        SectionMasterEntity sectionMasterEntity = new SectionMasterEntity();

        if (model != null) {
            Optional<ClassMasterEntity> classMasterEntity = classMasterEntityRepository.findById(model.getClassId());
            if (classMasterEntity.isPresent()) {
                entity = classMasterEntity.get();
            }
            sectionMasterEntity.setSectionName(model.getSectionName());
            sectionMasterEntity.setClassMaster(entity);
            sectionMasterEntityRepository.save(sectionMasterEntity);
            return true;
        }
        return false;
    }

    //@Cacheable(value = "classCache", key = "#classId")
    @Override
    public List<SectionModel> getSectionListByClassId(Long classId) {
        ClassMasterEntity entity = new ClassMasterEntity();
        entity.setId(classId);
        List<SectionMasterEntity> sectionList = sectionMasterEntityRepository.findByClassMaster(entity);
        return sectionList.stream().map(
                sectionEntity -> {
                    SectionModel sectionModel = new SectionModel();
                    BeanUtils.copyProperties(sectionEntity, sectionModel);
                    return sectionModel;
                }).toList();
    }
}
