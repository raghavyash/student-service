package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.entity.SubjectMasterEntity;
import com.rsnvtech.erp.edu.model.SubjectModel;
import com.rsnvtech.erp.edu.repository.SubjectMasterEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectMasterEntityRepository subjectMasterEntityRepository;
    @Override
    public Boolean saveSubject(SubjectModel model) {
        SubjectMasterEntity entity= new SubjectMasterEntity();
        BeanUtils.copyProperties(model,entity);
        subjectMasterEntityRepository.save(entity);
        return true;
    }
}
