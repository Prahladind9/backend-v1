package edu.prao.workmotion.controller;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
import edu.prao.workmotion.model.EmployeeModel;
import edu.prao.workmotion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("addEmployee")
    public EmployeeModel addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    @GetMapping("getEmployeeDetails/{employeeId}")
    public EmployeeModel getEmployeeDetails(@PathVariable Long employeeId){
        //can add validations on employeeId
        return this.employeeService.getEmployeeDetails(employeeId);
    }

    @PostMapping("updateEmployeeState/{employeeId}")
    public EmployeeModel updateEmployeeState(@PathVariable Long employeeId, @RequestParam EmployeeEvent event){
        //can add validations on employeeId, event
        return this.employeeService.updateEmployeeState(employeeId, event);
    }
}
