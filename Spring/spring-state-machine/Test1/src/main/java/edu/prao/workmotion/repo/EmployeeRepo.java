package edu.prao.workmotion.repo;

import edu.prao.workmotion.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
