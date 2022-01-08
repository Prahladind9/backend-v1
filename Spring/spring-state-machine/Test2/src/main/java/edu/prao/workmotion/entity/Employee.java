package edu.prao.workmotion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "employeeId_Seq")
public class Employee { //serialization not required

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeId_Seq")
    @Column(name = "employeeId", nullable = false, updatable = false)
    private Long id;

    private String name;
//    private int age;
//    private String company;
    //todo: define contract information

    @Enumerated(EnumType.STRING)
    private EmployeeState state;

}
