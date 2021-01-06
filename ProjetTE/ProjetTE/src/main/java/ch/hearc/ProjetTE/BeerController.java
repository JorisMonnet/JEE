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
	static {
		listBeer.add(new Beer(5,"Nom","Heineken",4.5,0.33,ColorType.BLONDE,FermentationType.EN_BOUTEILLE,StyleType.SOUR));
		listBeer.add(new Beer(10,"Nom","Heineken",5,0.33,ColorType.AMBREE,FermentationType.HAUTE,StyleType.ABBAYE));
		listBeer.add(new Beer(1,"Nom","Heineken",3.5,0.33,ColorType.BLONDE,FermentationType.MIXTE,StyleType.FUT));
		listBeer.add(new Beer(2,"Nom","Heineken",4.5,0.5,ColorType.BLANCHE,FermentationType.SPONTANEE,StyleType.BLANCHE));
		listBeer.add(new Beer(50,"Nom","Heineken",2.5,0.25,ColorType.BRUNE,FermentationType.BASSE,StyleType.PALE_ALE));
		listBeer.add(new Beer(64,"Nom","Heineken",10,1,ColorType.BRUNE,FermentationType.EN_BOUTEILLE,StyleType.STOUT));
	}
	
	private String notificationMessage;
	
	@GetMapping
	public String showBeers(Model model) {
		model.addAttribute("notification",notificationMessage);
		model.addAttribute("beers",listBeer);
		model.addAttribute("addBeerForm",new AddBeerForm());
		return "Beers";
	}
	
	@GetMapping("/{id}")
	public String showBeer(Model model,@PathVariable("id") int id){
		model.addAttribute("beer",listBeer.get(id));
		return "BeerDetail";
	}
	
	@PostMapping("/addBeer")
	public String createbeer(Model model, @ModelAttribute("addBeerForm") AddBeerForm addBeerForm) {
		if(addBeerForm.getPrice()<0) {
			notificationMessage = "Prix négatif, ajout annulé";
			return "Beers";
		}
		if(addBeerForm.getSize()<0) {
			notificationMessage = "Taille négative, ajout annulé";
			return "Beers";	
		}
		if(addBeerForm.getStock()<0) {
			notificationMessage = "Nombre en stock négatif, ajout annulé";
			return "Beers";	
		}
		listBeer.add(new Beer(addBeerForm));
		return "Beers";
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteBeer(@PathVariable("id") int id) {
		if(listBeer.remove(id)!=null) {
			notificationMessage = "Beer Deleted";
		} else {
			notificationMessage = "Beer"+ id +"doesn't exist";
		}
		return "Beers";
	}
}