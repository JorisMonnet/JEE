package ch.hearc.ProjetTE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.hearc.ProjetTE.Beer.ColorType;
import ch.hearc.ProjetTE.Beer.FermentationType;
import ch.hearc.ProjetTE.Beer.StyleType;

@Controller
@RequestMapping("/bieres")
public class BeerController {

	private static List<Beer> listBeer = new ArrayList<>();
	
	static { //add 5 beers
		listBeer.add(new Beer(5, "Nom", "Heineken", 4.5, 0.33, ColorType.BLONDE, FermentationType.EN_BOUTEILLE,
				StyleType.SOUR));
		listBeer.add(
				new Beer(10, "Nom", "Heineken", 5, 0.33, ColorType.AMBREE, FermentationType.HAUTE, StyleType.ABBAYE));
		listBeer.add(
				new Beer(1, "Nom", "Heineken", 3.5, 0.33, ColorType.BLONDE, FermentationType.MIXTE, StyleType.FUT));
		listBeer.add(new Beer(2, "Nom", "Heineken", 4.5, 0.5, ColorType.BLANCHE, FermentationType.SPONTANEE,
				StyleType.BLANCHE));
		listBeer.add(new Beer(50, "Nom", "Heineken", 2.5, 0.25, ColorType.BRUNE, FermentationType.BASSE,
				StyleType.PALE_ALE));
		listBeer.add(new Beer(64, "Nom", "Heineken", 10, 1, ColorType.BRUNE, FermentationType.EN_BOUTEILLE,
				StyleType.STOUT));
		for (int i = 0; i < listBeer.size(); i++)
			listBeer.get(i).setIndex(i);
	}

	private String notificationMessage;

	/**
	 * Show all Beers
	 * 
	 * @param model
	 * @return the view of all the beers
	 */
	@GetMapping
	public String showBeers(Model model) {
		model.addAttribute("notification", notificationMessage);
		model.addAttribute("beers", listBeer);
		model.addAttribute("addBeerForm", new AddBeerForm());
		return "Beers";
	}

	/**
	 * Show one Beer
	 * 
	 * @param model
	 * @param id of the beer
	 * @return view of this Beer
	 */
	@GetMapping("/{id}")
	public String showBeer(Model model, @PathVariable("id") int id) {
		model.addAttribute("beer", listBeer.get(id));
		model.addAttribute("updateBeerForm", new AddBeerForm());
		return "BeerDetail";
	}

	/**
	 * Add a Beer 
	 * 
	 * @param model
	 * @param addBeerForm the values of the new beer
	 * @return view of all Beers
	 */
	@PostMapping("/addBeer")
	public String createbeer(Model model, @ModelAttribute("addBeerForm") AddBeerForm addBeerForm) {
		listBeer.add(new Beer(addBeerForm, listBeer.size()));
		notificationMessage = "Bière ajoutée !";
		return "Beers";
	}

	/**
	 * Delete a Beer
	 * 
	 * @param model
	 * @param id of the beer
	 * @return the view of all beers
	 */
	@DeleteMapping("/{id}/delete")
	public String deleteBeer(Model model, @PathVariable("id") int id) {
		if (listBeer.remove(id) != null) {
			notificationMessage = "Bière supprimée";
			for (int i = 0; i < listBeer.size(); i++) {
				listBeer.get(i).setIndex(i);
			}
		} else {
			notificationMessage = "Biere " + id + " n'existe pas";
		}
		return "Beers";
	}
	
	/**
	 * update a Beer
	 * 
	 * @param model
	 * @param id of the beer
	 * @param updateBeerForm the values of the new beer
	 * @return the view of this beer
	 */
	@PostMapping("/{id}/update")
	public String updateBeer(Model model, @PathVariable("id") int id,
			@ModelAttribute("addBeerForm") AddBeerForm updateBeerForm) {
		listBeer.get(id).setValues(updateBeerForm);
		notificationMessage = "Bière modifiée";
		return "BeerDetail";

	}
}