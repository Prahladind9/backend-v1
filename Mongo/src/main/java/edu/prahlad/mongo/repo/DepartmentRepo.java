package edu.prahlad.mongo.repo;

import edu.prahlad.mongo.entiity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, String> {
}
