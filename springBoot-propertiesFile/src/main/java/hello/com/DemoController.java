package hello.com;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class DemoController {
	@Value("${student.id}")
	private int id;
	@Value("${student.name}")
	private String name;
	
	@RequestMapping("/")
	public String home() {
		return "student name  "+name+"   Student id "+id;
		
	}

}
