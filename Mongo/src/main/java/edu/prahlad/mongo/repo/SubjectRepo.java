package edu.prahlad.mongo.repo;

import edu.prahlad.mongo.entiity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends MongoRepository<Subject, String> {
}
