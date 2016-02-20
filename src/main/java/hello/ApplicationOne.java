package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@RequestMapping(value = "/docker1")
public class ApplicationOne {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationOne.class, args);
	}

	@RequestMapping(value = "/hello")
	public String welcome() {
		return "You called app 1";
	}

	@RequestMapping(value = "/call-1-to-2")
	public ResponseEntity<?> callTheOtherApp() {

		final String url = "http://localhost:8085/docker2/hello";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);

		System.out.println(result);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}