package dev.wcs.sea.trainingplanner;

import dev.wcs.sea.trainingplanner.entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/students")
	public List<Student> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<Student> students  = new ArrayList<>();
		Student student1 = new Student(1l,"Fritz", "Meier", LocalDate.now());
		students.add(student1);
		//		2. Studenten reinbringen (LK)
		Student student2 = new Student(2l,"Horst", "Scholz", LocalDate.now());
		students.add(student2);


		return students;
	}
}
