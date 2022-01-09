package edu.prao.workmotion.controller;

import edu.prao.workmotion.apiSpec.EmployeeApiSpec;
import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.model.EmployeeModel;
import edu.prao.workmotion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class EmployeeController implements EmployeeApiSpec {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeModel> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.employeeService.addEmployee(employee));
    }

    @Override
    public ResponseEntity<EmployeeModel> getEmployeeDetails(@PathVariable Long employeeId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.employeeService.getEmployeeDetails(employeeId));
    }

    @Override
    public ResponseEntity<EmployeeModel> updateEmployeeState(@PathVariable Long employeeId, @RequestParam String event) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.employeeService.updateEmployeeState(employeeId, event))
                ;
    }
}
