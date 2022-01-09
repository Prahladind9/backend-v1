package edu.prao.workmotion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "employeeId_Seq")
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeId_Seq")
    @Column(name = "employeeId", nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "Please provide OrgId")
    @Positive(message = "OrgId can't be a negative number")
    private Long orgId; //can be used for FeatureFlag control, AutoScalingGroup

    @NotNull(message = "Please provide an employee name")
    private String name;

    @NotNull(message = "Please provide an employee age")
    @Positive(message = "Age can't be a negative number")
    @Min(value = 18, message = "Legal work age >18")
    private int age;

    //Contract details can be an separate entity
    @NotNull(message = "Please provide an Contract Details")
    private String contractCompany;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contractStart;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contractEnd;

    @Enumerated(EnumType.STRING)
    private EmployeeState state;

    @Transient
    private String subState;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime lastUpdatedAt;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EmployeeState lastUpdatedState;

}
