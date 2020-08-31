package zup.com.br.zupedin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
	
	@GetMapping(value = "/")
	public String test() {
		return "Olá Mundo Rest";
	}

}
