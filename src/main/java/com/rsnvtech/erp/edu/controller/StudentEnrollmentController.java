package com.rsnvtech.erp.edu.controller;

import com.rsnvtech.erp.edu.model.StudentEnrollmentModel;
import com.rsnvtech.erp.edu.model.StudentLoginModel;
import com.rsnvtech.erp.edu.model.StudentModel;
import com.rsnvtech.erp.edu.services.StudentEnrollmentService;
import com.rsnvtech.erp.edu.services.StudentLoginService;
import com.rsnvtech.erp.edu.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/student/enroll")
public class StudentEnrollmentController {

    @Autowired
    private StudentEnrollmentService studentEnrollmentService;

/*http://localhost:8092/v1/student/enroll/save

{
    "studentId":"1",
    "classId":"1",
    "batchYear":"2026",
    "enrollDate":"2026-05-27T18:30:00"

}
*/
    @PostMapping({"/save"})
    public ResponseEntity<Boolean> saveCategory(@RequestBody StudentEnrollmentModel model) {
        boolean result = this.studentEnrollmentService.saveStudentEnrollment(model);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // PATCH method for partial update
    @PatchMapping("/update")
    public ResponseEntity<Boolean> updateMobileNumber(
            @RequestBody StudentEnrollmentModel model) {
        Boolean updatedUser = studentEnrollmentService.updateStudentEnrollment(model);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
