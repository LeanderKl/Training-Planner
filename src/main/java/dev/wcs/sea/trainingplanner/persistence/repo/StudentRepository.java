package dev.wcs.sea.trainingplanner.persistence.repo;

import dev.wcs.sea.trainingplanner.persistence.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
