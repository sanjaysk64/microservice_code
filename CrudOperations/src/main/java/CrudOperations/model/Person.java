package CrudOperations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Size(min=3, message = " person Name should have alteast 3 characters")
	private String name;

	@NotNull(message = "phoneNUm should not be null")
	@Size(min = 10, max=10 ,message = "Enter valid phoneNumber")
	private String phone;
 	
	@NotNull(message = "dep name should not be null")
 	@Size(min=1, message = "dep name should not be null")
	private String dept;
	
	@NotNull(message = " age should not be null")
	@Min(2)
	private Integer age;

	public Person() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(Integer id, @NotNull @Size(min = 3, message = " Name should have alteast 3 characters") String name,
			String phone, String dept, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.dept = dept;
		this.age = age;
	}

	 
}
