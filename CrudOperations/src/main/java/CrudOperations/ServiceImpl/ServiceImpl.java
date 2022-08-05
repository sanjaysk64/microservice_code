package CrudOperations.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import CrudOperations.exceptionhandller.AgeInvalidException;
import CrudOperations.model.Company;
import CrudOperations.model.Person;
import CrudOperations.repo.CompanyRepository;
import CrudOperations.repo.PersonRepo;
import CrudOperations.service.PersonService;

@Service
public class ServiceImpl implements PersonService {

	@Autowired
	PersonRepo repo;

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<Person> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Person> getBySorting(String field) {
		return repo.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public Page<Person> findPersonsWithPagination(Integer offset, Integer pagesize) {
		return repo.findAll(PageRequest.of(offset, pagesize));
	}

	@Override
	public Page<Person> getPersonsWithPaginationAndSorting(Integer offset, Integer pagesize, String field) {
		return repo.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(Sort.Direction.ASC, field)));
	}

	@Override
	public Company saveAll(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public String deleteById(Integer id) {
		repo.deleteById(id);
		return "deleted";
	}

	@Override
	public boolean UpdateNameById(Integer id, Person person) {
		Person persons = repo.findById(id).get();
		persons.setName(person.getName());
		repo.save(persons);
		return true;
	}

	@Override
	public List<Person> getByName(String name) {

		return repo.findByName(name);
	}

	@Override
	public boolean UpdateAgeById(Integer id, Person person) {
		Person person2 = repo.findById(id).get();
		person2.setAge(person.getAge());
		repo.save(person2);
		return true;
	}

}
