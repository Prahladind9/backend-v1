package edu.prao.workmotion.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.prao.workmotion.entity.Employee;
import edu.prao.workmotion.model.EmployeeModel;
import edu.prao.workmotion.repo.EmployeeRepo;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    private TestRestTemplate restTemplate;
    private String basePath;

    @BeforeEach
    void beforeEach() {
        basePath = String.format("http://localhost:%d/employee", port);
        restTemplate = new TestRestTemplate();
    }

    @Test
    void should_add_employee() throws IOException {
        // arrange
        Employee requestEmployee = getParsedEmployee("/addEmployee/requestEmployee.json");
        EmployeeModel expectedEmployeeModelResponse = getParsedEmployeeModel("/addEmployee/expectedResponse.json");
        Employee expectedEmployeeResponse = expectedEmployeeModelResponse.getEmployee();

        // act
        ResponseEntity<EmployeeModel> response = restTemplate.postForEntity(basePath + "/addEmployee", requestEmployee, EmployeeModel.class);
        Employee actualEmployeeResponse = response.getBody().getEmployee();
        EmployeeModel actualEmployeeModelResponse = response.getBody();

        System.out.println("actualEmployeeModelResponse"+ actualEmployeeModelResponse);
        System.out.println("expectedEmployeeModelResponse"+ expectedEmployeeModelResponse);

        // assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());

        assertEquals(expectedEmployeeResponse.getOrgId(), actualEmployeeResponse.getOrgId());
        assertEquals(expectedEmployeeResponse.getName(), actualEmployeeResponse.getName());
        assertEquals(expectedEmployeeResponse.getAge(), actualEmployeeResponse.getAge());
        assertEquals(expectedEmployeeResponse.getContractCompany(), actualEmployeeResponse.getContractCompany());
        assertEquals(expectedEmployeeResponse.getContractStart(), actualEmployeeResponse.getContractStart());
        assertEquals(expectedEmployeeResponse.getContractEnd(), actualEmployeeResponse.getContractEnd());
        assertEquals(expectedEmployeeResponse.getState(), actualEmployeeResponse.getState());

        assertEquals(expectedEmployeeModelResponse.getTargetState(), actualEmployeeModelResponse.getTargetState());
        assertEquals(expectedEmployeeModelResponse.getNextPossibleEvent(), actualEmployeeModelResponse.getNextPossibleEvent());

    }

    @Test
    void should_get_employee() throws IOException {
        // arrange
        Employee requestEmployee = getParsedEmployee("/addEmployee/requestEmployee.json");
        EmployeeModel expectedEmployeeModelResponse = getParsedEmployeeModel("/getEmployee/expectedResponse.json");
        Employee expectedEmployeeResponse = expectedEmployeeModelResponse.getEmployee();

        // act
        restTemplate.postForEntity(basePath + "/addEmployee", requestEmployee, EmployeeModel.class);
        ResponseEntity<EmployeeModel> response = restTemplate.getForEntity(basePath + "/getEmployeeDetails/1", EmployeeModel.class);
        Employee actualEmployeeResponse = response.getBody().getEmployee();
        EmployeeModel actualEmployeeModelResponse = response.getBody();

        System.out.println("actualEmployeeModelResponse"+ actualEmployeeModelResponse);
        System.out.println("expectedEmployeeModelResponse"+ expectedEmployeeModelResponse);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());

        assertEquals(expectedEmployeeResponse.getOrgId(), actualEmployeeResponse.getOrgId());
        assertEquals(expectedEmployeeResponse.getName(), actualEmployeeResponse.getName());
        assertEquals(expectedEmployeeResponse.getAge(), actualEmployeeResponse.getAge());
        assertEquals(expectedEmployeeResponse.getContractCompany(), actualEmployeeResponse.getContractCompany());
        assertEquals(expectedEmployeeResponse.getContractStart(), actualEmployeeResponse.getContractStart());
        assertEquals(expectedEmployeeResponse.getContractEnd(), actualEmployeeResponse.getContractEnd());
        assertEquals(expectedEmployeeResponse.getState(), actualEmployeeResponse.getState());

        assertEquals(expectedEmployeeModelResponse.getTargetState(), actualEmployeeModelResponse.getTargetState());
        assertEquals(expectedEmployeeModelResponse.getNextPossibleEvent(), actualEmployeeModelResponse.getNextPossibleEvent());

    }

    @Test
    void should_update_employee() throws IOException {
        // arrange
        Employee requestEmployee = getParsedEmployee("/addEmployee/requestEmployee.json");
        EmployeeModel expectedEmployeeModelResponse = getParsedEmployeeModel("/updateEmployeeState/expectedResponse.json");
        Employee expectedEmployeeResponse = expectedEmployeeModelResponse.getEmployee();

        // act
        restTemplate.postForEntity(basePath + "/addEmployee", requestEmployee, EmployeeModel.class);
        restTemplate.getForEntity(basePath + "/getEmployeeDetails/1", EmployeeModel.class);
        ResponseEntity<EmployeeModel> response = restTemplate.postForEntity(basePath + "/updateEmployeeState/1?event=TO_IN_CHECK", null,  EmployeeModel.class);
        Employee actualEmployeeResponse = response.getBody().getEmployee();
        EmployeeModel actualEmployeeModelResponse = response.getBody();

        System.out.println("actualEmployeeModelResponse"+ actualEmployeeModelResponse);
        System.out.println("expectedEmployeeModelResponse"+ expectedEmployeeModelResponse);

        // assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());

        assertEquals(expectedEmployeeResponse.getOrgId(), actualEmployeeResponse.getOrgId());
        assertEquals(expectedEmployeeResponse.getName(), actualEmployeeResponse.getName());
        assertEquals(expectedEmployeeResponse.getAge(), actualEmployeeResponse.getAge());
        assertEquals(expectedEmployeeResponse.getContractCompany(), actualEmployeeResponse.getContractCompany());
        assertEquals(expectedEmployeeResponse.getContractStart(), actualEmployeeResponse.getContractStart());
        assertEquals(expectedEmployeeResponse.getContractEnd(), actualEmployeeResponse.getContractEnd());
        assertEquals(expectedEmployeeResponse.getState(), actualEmployeeResponse.getState());

        assertEquals(expectedEmployeeModelResponse.getTargetState(), actualEmployeeModelResponse.getTargetState());
        assertEquals(expectedEmployeeModelResponse.getNextPossibleEvent(), actualEmployeeModelResponse.getNextPossibleEvent());


    }


    private Employee getParsedEmployee(String path) throws IOException {
        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(TypeReference.class.getResourceAsStream(path), Employee.class);
    }

    private EmployeeModel getParsedEmployeeModel(String path) throws IOException {
        ObjectMapper mapper = mapperBuilder.build();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(TypeReference.class.getResourceAsStream(path), EmployeeModel.class);
    }


}
