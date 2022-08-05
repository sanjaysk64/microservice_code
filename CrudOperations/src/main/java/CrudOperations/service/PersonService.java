package CrudOperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import CrudOperations.model.Company;
import CrudOperations.model.Person;
import CrudOperations.repo.PersonRepo;

public interface PersonService {

	public Company saveAll(Company company);

	public List<Person> getAll();

	public Page<Person> findPersonsWithPagination(Integer offset, Integer pagesize);

	public String deleteById(Integer id);

	public boolean UpdateNameById(Integer id, Person person);

	public List<Person> getByName(String name);

	public boolean UpdateAgeById(Integer id, Person person);

	public List<Person> getBySorting(String field);

	public Page<Person> getPersonsWithPaginationAndSorting(Integer offset, Integer pagesize, String field);

}
