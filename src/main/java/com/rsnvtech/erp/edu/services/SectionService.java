package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.model.SectionModel;

import java.util.List;

public interface SectionService {
    Boolean saveSection(SectionModel model);
    List<SectionModel> getSectionListByClassId(Long classId);
}
