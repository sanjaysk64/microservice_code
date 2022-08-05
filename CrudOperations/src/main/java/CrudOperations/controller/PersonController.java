package CrudOperations.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CrudOperations.exceptionhandller.AgeInvalidException;
import CrudOperations.model.Company;
import CrudOperations.model.Person;
import CrudOperations.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping("/post")
	public Company save(@Valid @RequestBody Company company) {
		return personService.saveAll(company);
	}

	@GetMapping("getAll")
	public List<Person> getAll() {
		return personService.getAll();
	}

	@GetMapping("getAllBysorting/{field}")
	public List<Person> getAllBysorting(@PathVariable String field) {
		List<Person> alllist = personService.getBySorting(field);
		return alllist;
	}

	@GetMapping("PaginationAndSorting/{offset}/{pagesize}/{field}")
	public Page<Person> getPersonsWithPaginationAndSorting(@PathVariable Integer offset, @PathVariable Integer pagesize,
			@PathVariable String field) {
		return personService.getPersonsWithPaginationAndSorting(offset, pagesize, field);
	}

	@DeleteMapping("deleteById/{id}")
	public String deleteById(@PathVariable Integer id) {
		personService.deleteById(id);
		return "deleted";
	}

	@PutMapping("update/{id}")
	public boolean UpdateNameById(@PathVariable Integer id, @Valid @RequestBody Person person) {
		personService.UpdateNameById(id, person);
		return true;
	}

	@GetMapping("getByName/{name}")
	
	public List<Person> getByName(@PathVariable String name) {
		return personService.getByName(name);
	}

	@PutMapping("updateAge/{id}")
	public boolean updateAge(@PathVariable Integer id, @RequestBody Person person) throws AgeInvalidException {
		if (person.getAge() < 18) {
			throw new AgeInvalidException("Age should be greater than 18");
		}
		return true;
	}
}
