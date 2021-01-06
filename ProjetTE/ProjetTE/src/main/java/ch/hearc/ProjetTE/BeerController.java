package ch.hearc.ProjetTE;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.ProjetTE.Beer.ColorType;
import ch.hearc.ProjetTE.Beer.FermentationType;
import ch.hearc.ProjetTE.Beer.StyleType;

@Controller
@RequestMapping("/bieres")
public class BeerController {
	
	private static List<Beer> listBeer = new ArrayList<>();
	static {
		listBeer.add(new Beer(5,"Nom","Heineken",4.5,0.33,ColorType.BLONDE,FermentationType.EN_BOUTEILLE,StyleType.SOUR));
		listBeer.get(0).setIndex(0);
	}
	/* {
		{
			add(new Beer(5,"Nom","Heineken",4.5,0.33,ColorType.BLONDE,FermentationType.EN_BOUTEILLE,StyleType.SOUR).setIndex(0));
			put(1,new Beer(10,"Nom","Heineken",5,0.33,ColorType.AMBREE,FermentationType.HAUTE,StyleType.ABBAYE).setIndex(0));
			put(2,new Beer(1,"Nom","Heineken",3.5,0.33,ColorType.BLONDE,FermentationType.MIXTE,StyleType.FUT).setIndex(0));
			put(3,new Beer(2,"Nom","Heineken",4.5,0.5,ColorType.BLANCHE,FermentationType.SPONTANEE,StyleType.BLANCHE).setIndex(0));
			put(4,new Beer(50,"Nom","Heineken",2.5,0.25,ColorType.BRUNE,FermentationType.BASSE,StyleType.PALE_ALE).setIndex(0));
			put(5,new Beer(64,"Nom","Heineken",10,1,ColorType.BRUNE,FermentationType.EN_BOUTEILLE,StyleType.STOUT).setIndex(0));
		}
	};*/
	
	private String notificationMessage;
	
	@GetMapping
	public String showBeers(Model model) {
		model.addAttribute("notification",notificationMessage);
		model.addAttribute("beers",listBeer);
		return "Beers";
	}
	
	@GetMapping("/{id}")
	public String showBeer(Model model,@PathVariable("id") int id){
		model.addAttribute("beer",listBeer.get(id));
		return "BeerDetail";
	}
	@PostMapping
	public void createbeer(@RequestParam int i) {
		
	}
	
	@DeleteMapping(value = "/{id}/delete")
	public String deleteBeer(@PathVariable("id") int id) {
		if(listBeer.remove(id)!=null) {
			notificationMessage = "Beer Deleted";
		} else {
			notificationMessage = "Beer"+ id +"doesn't exist";
		}
		return "redirect:/bieres";
	}
	
}