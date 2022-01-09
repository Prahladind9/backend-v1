package edu.prao.workmotion.model;

import edu.prao.workmotion.entity.Employee;
import lombok.*;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeModel {

    private Employee employee;
    private String nextActionToTake;
    private List<String> nextPossibleEvent;

    private String targetState;
}
