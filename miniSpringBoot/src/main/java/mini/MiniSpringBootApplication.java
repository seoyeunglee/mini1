package mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class MiniSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniSpringBootApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "thymeleaf/index";
	}

}
