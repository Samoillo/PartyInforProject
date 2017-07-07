package pl.PartyInfor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, message="Podaj login składający się przynajmniej z 3 znaków")
	private String login;
	
	
	@Size(min = 3, max = 8, message="Podaj hasło składający się przynajmniej z 3 znaków")
	private String password;
	
	@NotBlank(message="Podaj swoje imię")
	private String firstName;

	@NotBlank(message="Podaj swoje nazwisko")
	private String lastName;

	private String number;

	@Email(message="Wypełnij poprawnie E-mail")
	private String email;

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE )
	private List<Post> posts = new ArrayList<>();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(Post post) {
		posts.add(post);
	}
	
}
