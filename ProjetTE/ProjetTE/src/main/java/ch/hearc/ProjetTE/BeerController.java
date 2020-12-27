package ch.hearc.ProjetTE;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bieres")
public class BeerController {

	private Map<Integer,Beer> mapBeer = new HashMap<>();
			
	@GetMapping
	public void showBeers() {
		
	}
	
	@GetMapping
	public void showBeer(@RequestParam int id){
		Beer beer = mapBeer.get(id);
		
	}
	@PostMapping
	public void createbeer() {
		
	}
	
	@DeleteMapping
	public void deleteBeer() {
		
	}
	
}