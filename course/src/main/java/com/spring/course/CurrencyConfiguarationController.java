package com.spring.course;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfiguarationController {
	
	@RequestMapping("/currency-configuration")
	public List<Course> retrievalAllCourses()
	{
		return Arrays.asList(new Course(1,"aws","software"));
	}
}