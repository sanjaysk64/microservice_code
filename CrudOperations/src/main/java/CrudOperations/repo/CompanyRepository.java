package CrudOperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CrudOperations.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
