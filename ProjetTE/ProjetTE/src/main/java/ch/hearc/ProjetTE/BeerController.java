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

@Controller
@RequestMapping("/bieres")
public class BeerController {

	private static List<Beer> listBeer = new ArrayList<>();

	static { // add 5 beers
		listBeer.add(new Beer(48, "La mousse", "Heineken", 2.5, 0.33, ColorType.Blonde, FermentationType.Inconnue,
				StyleType.Lager));
		listBeer.add(
				new Beer(24, "1664", "Kronenbourg", 5, 0.33, ColorType.Blonde, FermentationType.Haute, StyleType.Lager));
		listBeer.add(
				new Beer(1, "ambrée", "trobonix", 3.5, 0.33, ColorType.Ambree, FermentationType.Spontanee, StyleType.Fut));
		listBeer.add(new Beer(2, "red", "Desperado", 4.5, 0.5, ColorType.Inconnue, FermentationType.EnBouteille,
				StyleType.Sour));
		listBeer.add(new Beer(50, "Brune", "Grimbergen", 2.5, 0.25, ColorType.Brune, FermentationType.Basse,
				StyleType.Abbaye));
		listBeer.add(new Beer(64, "l'anglaise", "Spitfire", 10, 1, ColorType.Blanche, FermentationType.EnBouteille,
				StyleType.Stout));
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
	 * @param id    of the beer
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
		return "redirect:/bieres";
	}

	/**
	 * Delete a Beer
	 * 
	 * @param model
	 * @param id    of the beer
	 * @return the view of all beers
	 */
	@GetMapping("/{id}/delete")
	public String deleteBeer(Model model, @PathVariable("id") int id) {
		if (listBeer.remove(id) != null) {
			notificationMessage = "Bière supprimée";
			for (int i = 0; i < listBeer.size(); i++) {
				listBeer.get(i).setIndex(i);
			}
		} else {
			notificationMessage = "Biere " + id + " n'existe pas";
		}
		return "redirect:/bieres";
	}

	/**
	 * Update a Beer
	 * 
	 * @param model
	 * @param id             of the beer
	 * @param updateBeerForm the values of the new beer
	 * @return the view of this beer
	 */
	@PostMapping("/{id}/update")
	public String updateBeer(Model model, @PathVariable("id") int id,
			@ModelAttribute("addBeerForm") AddBeerForm updateBeerForm) {
		listBeer.get(id).setValues(updateBeerForm);
		notificationMessage = "Bière modifiée";
		return "redirect:/bieres/"+id;

	}
}