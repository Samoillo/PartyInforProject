package pl.PartyInfor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.PartyInfor.entity.District;
import pl.PartyInfor.repository.DistrictRepository;

@Controller
@RequestMapping("/districts")
public class DistrictController {

	@Autowired
	private DistrictRepository districtRepository;


	/*
	 * 1 pkt Zarządzanie encjami W przypadku zmiany na REST
	 */

	// Tworzenie encji i zwracanie JSON
	@RequestMapping(method = RequestMethod.POST)
	public District addDistrict() {
		District district = new District();
		district.setArea("Bulwar Wiślany");

		districtRepository.save(district);

		return district;
	}

	// Pobieranie Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public District getDistrict(@PathVariable Long id) {
		District district = districtRepository.findOne(id);

		return district;
	}

	// Edycja Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public District updateDistrict(@PathVariable Long id) {
		District district = districtRepository.findOne(id);
		district.setArea(district.getArea() + " updated");
		districtRepository.save(district);

		return district;
	}

	// Usuwanie Encji
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteDistrict(@PathVariable Long id) {
		District district = districtRepository.findOne(id);
		districtRepository.delete(district);
	}

	/*
	 * 2 pkt Dodawanie
	 */

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddDistrictForm(Model model) {

		model.addAttribute("district", new District());
		return "districtForm";
	}

	// Wprowadzona walidacja
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processAddDistrictForm(@Valid @ModelAttribute District district,
			BindingResult result) {
		if (result.hasErrors()) {
			return "districtForm";
		}
		districtRepository.save(district);

		return "redirect:/";
	}


	/*
	 * 3 pkt Wyświetlanie Listy po dodaniu
	 */

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showDistricts(Model model) {
		model.addAttribute("districts", districtRepository.findAll());

		return "districtList";
	}
	


	/*
	 * 4 pkt Link do edycji
	 */

	@RequestMapping(path = "edit/{id}", method = RequestMethod.GET)
	public String editDistrictForm(@PathVariable long id, Model model) {
		model.addAttribute("district", districtRepository.findOne(id));
		return "districtForm";
	}

	@RequestMapping(path = "edit/{id}", method = RequestMethod.POST)
	public String processEditDistrictForm(@Valid @ModelAttribute District district, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "districtForm";
		}
		districtRepository.save(district);

		return "redirect:/";
	}


	/*
	 * 5 pkt Link do usuwania - bez pytania
	 */

	@RequestMapping(path = "delete/{id}", method = RequestMethod.GET)
	public String processDeleteDistrictForm(@PathVariable long id) {
		districtRepository.delete(districtRepository.findOne(id));

		return "redirect:/";
	}
	
	
	

}
