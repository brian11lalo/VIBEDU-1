package vibedu.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class Home {

	@GetMapping("/")
	public String Home_(){
		return "index";
	}
	
}
