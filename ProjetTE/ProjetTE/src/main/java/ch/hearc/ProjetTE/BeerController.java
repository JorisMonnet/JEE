package ch.hearc.ProjetTE;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Beers")
public class BeerController {

	private Map<Integer,Beer> mapBeer = new HashMap<>();
			
	@GetMapping
	public void showBeers(Model model) {
		
	}
	
	@GetMapping("/{id}")
	public void showBeer(@RequestParam int id){
		Beer beer = mapBeer.get(id);
		
	}
	@PostMapping
	public void createbeer(@RequestParam int i) {
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteBeer(@RequestParam(value = "name") int id) {
		
	}
	
}