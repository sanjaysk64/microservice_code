package CrudOperations.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CrudOperations.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

	List<Person> findByName(String name);
}
