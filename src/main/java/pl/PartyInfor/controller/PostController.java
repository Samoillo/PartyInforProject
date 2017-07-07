package pl.PartyInfor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.PartyInfor.entity.District;
import pl.PartyInfor.entity.Post;
import pl.PartyInfor.repository.DistrictRepository;
import pl.PartyInfor.repository.PostRepository;
import pl.PartyInfor.repository.UserRepository;

@Controller
@RequestMapping("/")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DistrictRepository districtRepository;

	/*
	 * 1 pkt Zarządzanie encjami W przypadku zmiany na REST
	 */

	// Tworzenie encji i zwracanie JSON
	@RequestMapping(method = RequestMethod.POST)

	public Post addPost() {
		Post post = new Post();
		post.setText("Impreza chujem śmierdzi");
		post.setPlace("Hocki Klocki");
		postRepository.save(post);

		return post;
	}

	// Pobieranie Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Post getPost(@PathVariable Long id) {
		Post post = postRepository.findOne(id);

		return post;
	}

	// Edycja Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Post updatePost(@PathVariable Long id) {
		Post post = postRepository.findOne(id);
		post.setText(post.getText() + " updated");
		postRepository.save(post);

		return post;
	}

	// Usuwanie Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable Long id) {
		Post post = postRepository.findOne(id);
		postRepository.delete(post);
	}

	/*
	 * 2 pkt Dodawanie
	 */

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddPostForm(Model model) {

		model.addAttribute("post", new Post());
		return "postForm";
	}

	// Wprowadzona walidacja
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processAddPostForm(@Valid @ModelAttribute Post post, BindingResult result,
			@SessionAttribute(required = false) Long userId) {
		if (result.hasErrors()) {
			return "postForm";
		}
		post.setUser(userRepository.findOne(userId));
		postRepository.saveAndFlush(post);

		return "redirect:/";
	}

	/*
	 * 3 pkt Wyświetlanie Listy po dodaniu
	 */

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showPosts(Model model) {
		model.addAttribute("posts", postRepository.findAll());

		return "postList";
	}

	/*
	 * 4 pkt Link do edycji
	 */

	@RequestMapping(path = "edit/{id}", method = RequestMethod.GET)
	public String editPostForm(@PathVariable long id, Model model) {
		model.addAttribute("post", postRepository.findOne(id));
		return "postForm";
	}

	@RequestMapping(path = "edit/{id}", method = RequestMethod.POST)
	public String processEditPostForm(@Valid @ModelAttribute Post post, BindingResult result,
			@SessionAttribute(required = false) Long userId) {
		if (result.hasErrors()) {
			return "postForm";
		}
		post.setUser(userRepository.findOne(userId));
		postRepository.save(post);

		return "redirect:/";
	}

	/*
	 * 5 pkt Link do usuwania - bez pytania
	 */

	@RequestMapping(path = "delete/{id}", method = RequestMethod.GET)
	public String processDeletePostForm(@PathVariable long id) {
		postRepository.delete(postRepository.findOne(id));

		return "redirect:/users/account";
	}

	@ModelAttribute("districts")
	public List<District> getAllDistrict() {
		List<District> districts = districtRepository.findAll();
		return districts;
	}
	
	
	/*
	 * 6 pkt Wyświetlanie postów konkretnej grupy
	 */
	
	@RequestMapping(path = "/bulwary", method = RequestMethod.GET)
	public String showBulwaryPosts(Model model) {
		model.addAttribute("posts", postRepository.findByDistrictId(1));

		return "typedList";
	}
	
	@RequestMapping(path = "/centrum", method = RequestMethod.GET)
	public String showCentrumPosts(Model model) {
		model.addAttribute("posts", postRepository.findByDistrictId(2));

		return "typedList";
	}
	
	@RequestMapping(path = "/praga", method = RequestMethod.GET)
	public String showPragaPosts(Model model) {
		model.addAttribute("posts", postRepository.findByDistrictId(3));

		return "typedList";
	}
	
	@RequestMapping(path = "/pozostale", method = RequestMethod.GET)
	public String showPozostalePosts(Model model) {
		model.addAttribute("posts", postRepository.findByDistrictId(4));

		return "typedList";
	}
	

}
