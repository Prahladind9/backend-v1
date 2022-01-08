package edu.prao.workmotion.controller;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.entity.EmployeeEvent;
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
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    @GetMapping("fetchEmployeeDetails/{employeeId}")
    public Employee fetchEmployeeDetails(@PathVariable Long employeeId){
        return this.employeeService.fetchEmployeeDetails(employeeId);
    }

    @PostMapping("updateEmployeeState/{employeeId}")
    public Employee updateEmployeeState(@PathVariable Long employeeId, @RequestParam EmployeeEvent event){
        return this.employeeService.updateEmployeeState(employeeId, event);
    }
}
