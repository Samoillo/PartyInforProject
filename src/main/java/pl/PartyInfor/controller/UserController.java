package pl.PartyInfor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.PartyInfor.entity.User;
import pl.PartyInfor.repository.PostRepository;
import pl.PartyInfor.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	


	/*
	 * 1 pkt Zarządzanie encjami W przypadku zmiany na REST
	 */

	// Tworzenie encji i zwracanie JSON
	@RequestMapping(method = RequestMethod.POST)

	public User addUser() {
		User user = new User();
		user.setFirstName("Andrzej");
		user.setLastName("Samoillo");
		userRepository.save(user);

		return user;
	}

	// Pobieranie Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		User user = userRepository.findOne(id);

		return user;
	}

	// Edycja Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		user.setFirstName(user.getFirstName() + " updated");
		userRepository.save(user);

		return user;
	}

	// Usuwanie Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		userRepository.delete(user);
	}

	/*
	 * 2 pkt Dodawanie
	 */

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new User());
		return "userForm";
	}

	// Wprowadzona walidacja
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processAddUserForm(@Valid @ModelAttribute User user, BindingResult result) {

		if (result.hasErrors()) {
			return "userForm";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword())); // add.1
		userRepository.save(user);

		return "redirect:/";
	}


	/*
	 * 3 pkt Wyświetlanie Listy Wszystkich userów
	 */

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());

		return "userList";
	}


	/*
	 * 4 pkt Link do edycji 
	 */

	@RequestMapping(path = "edit/{id}", method = RequestMethod.GET)
	public String editUserForm(@PathVariable long id, Model model) {
		model.addAttribute("user", userRepository.findById(id));
		return "EditUserForm";
	}

	@RequestMapping(path = "edit/{id}", method = RequestMethod.POST)
	public String processEditUserForm(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors()) {
			return "EditUserForm";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword())); // add.1
		userRepository.save(user);

		return "redirect:/users/account";
	}


	/*
	 * 5 pkt Link do usuwania  - bez pytania
	 */

	@RequestMapping(path = "delete/{id}", method = RequestMethod.GET)
	public String processDeleteUserForm(@PathVariable long id) {
		userRepository.delete(userRepository.findOne(id));

		return "redirect:/";
	}

	/*
	 * 6 pkt Rejestracja i Logowanie
	 */

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "loginForm";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)

	public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
		User userToCheck = userRepository.findByLogin(user.getLogin());

		if (userToCheck != null && passwordEncoder.matches(user.getPassword(), userToCheck.getPassword())) {
			request.getSession().setAttribute("userId", userToCheck.getId());
			return "redirect:/";
		} else {
			request.getSession().removeAttribute("userId");
			return "redirect:/users/login";
		}
	}

	/*
	 * 7 pkt Weryfikacja
	 */

	@RequestMapping(path = "/verification", method = RequestMethod.GET)
	public String isVeryfied(@SessionAttribute(required = false) Long userId) {
		if (userId != null) {
			return "redirect:/add";
		} else {
			return "redirect:/users/login";
		}
	}

	@RequestMapping(path = "/authenticated", method = RequestMethod.GET)
	@ResponseBody
	public String isAuthenticated(@SessionAttribute(required = false) Long userId, HttpServletRequest request) {
		if (userId != null) {
			return "Login zalogowanego usera to: " + userId;
		} else {
			return "nie zalogowano";
		}

	}

	/*
	 * 8 pkt Wylogowywanie
	 */

	@RequestMapping(path = "/logoff", method = RequestMethod.GET)
	public String userLogOff(@SessionAttribute(required = false) Long userId, HttpServletRequest request) {

		request.getSession().invalidate();
		return "redirect:/";
	}

	/*
	 * 9 pkt Wyświetanie Usera w Moje konto
	 */

	 @RequestMapping(path = "/account", method = RequestMethod.GET)
	 public String showUser(Model model, @SessionAttribute(required = false) Long userId) {
		 
		 if(userId != null){
			 model.addAttribute("userLog", userRepository.findById(userId));
			 model.addAttribute("posts", postRepository.findByUserId(userId));
			 return "accountUser";
		 }else{
			 return "redirect:/";
		 }
	 
	 }

	
	 
}
