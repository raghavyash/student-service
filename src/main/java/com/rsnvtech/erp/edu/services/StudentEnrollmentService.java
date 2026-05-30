package com.rsnvtech.erp.edu.services;

import com.rsnvtech.erp.edu.model.StudentEnrollmentModel;

public interface StudentEnrollmentService {
    Boolean saveStudentEnrollment(StudentEnrollmentModel model);
    Boolean updateStudentEnrollment(StudentEnrollmentModel model);
}
