package edu.prao.workmotion.apiSpec;

import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.model.EmployeeModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Employee", description = "REST API for Employee.")
@RequestMapping("employee")
public interface EmployeeApiSpec {

    @Operation(summary = "${api.employee.add_employee.description}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
                    @ApiResponse(responseCode = "201", description = "${api.responseCodes.created.description}"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "${api.responseCodes.badRequest.description}"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "${api.responseCodes.notFound.description}")
            })
    @PostMapping("addEmployee")
    ResponseEntity<EmployeeModel> addEmployee(@RequestBody Employee body);


    @Operation(summary = "${api.employee.get_employee_details.description}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "${api.responseCodes.badRequest.description}"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "${api.responseCodes.notFound.description}")
            })
    @GetMapping("getEmployeeDetails/{employeeId}")
    ResponseEntity<EmployeeModel> getEmployeeDetails(@PathVariable Long employeeId);

    @Operation(summary = "${api.employee.update_employee_state.description}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "202", description = "${api.responseCodes.accepted.description}"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "${api.responseCodes.notFound.description}"),
            })
    @PostMapping("updateEmployeeState/{employeeId}")
    ResponseEntity<EmployeeModel> updateEmployeeState(@PathVariable Long employeeId, @RequestParam String event);
}
