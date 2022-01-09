package edu.prao.workmotion.model;

import edu.prao.workmotion.entity.Employee;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class EmployeeModel {

    private Employee employee;
    private String nextActionToTake;
    private List<String> nextPossibleEvent;

    private String targetState;
}
