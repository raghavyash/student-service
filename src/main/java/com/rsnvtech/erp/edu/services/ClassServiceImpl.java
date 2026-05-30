package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.entity.ClassMasterEntity;
import com.rsnvtech.erp.edu.model.ClassModel;
import com.rsnvtech.erp.edu.repository.ClassMasterEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMasterEntityRepository classMasterEntityRepository;

    @Override
    public Boolean saveClasses(ClassModel model) {
        ClassMasterEntity classMasterEntity = new ClassMasterEntity();
        BeanUtils.copyProperties(model, classMasterEntity);
        this.classMasterEntityRepository.save(classMasterEntity);
        return true;
    }
    public List<ClassModel> getClassList() {
        ClassMasterEntity classMasterEntity = new ClassMasterEntity();
        List<ClassMasterEntity> list = classMasterEntityRepository.findAll();
        return list.stream().map(entity -> {
            ClassModel model = new ClassModel();
            BeanUtils.copyProperties(entity, model);
            return model;
        }).toList();

    }

}
