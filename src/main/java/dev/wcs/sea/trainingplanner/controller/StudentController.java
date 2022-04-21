package dev.wcs.sea.trainingplanner.controller;

import dev.wcs.sea.trainingplanner.controller.dto.StudentDto;
import dev.wcs.sea.trainingplanner.persistence.entities.Student;
import dev.wcs.sea.trainingplanner.persistence.repo.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("/student_static")
	public List<Student> students() {
		List<Student> students  = new ArrayList<>();
		Student student1 = new Student("Fritz", "Meier", LocalDate.now());
		students.add(student1);
		//		2. Studenten reinbringen (LK)
		Student student2 = new Student("Horst", "Scholz", LocalDate.now());
		students.add(student2);
		// und noch eine 3.
		Student student3 = new Student("Fritzi", "Fratz", LocalDate.now());
		students.add(student3);

		return students;

	}

	@GetMapping("/student")
	public List<StudentDto> student() {
		Iterable<Student> studentEntities = studentRepository.findAll();
		List<StudentDto> studentsDto = new ArrayList<>();
		studentEntities.forEach( student -> {
				StudentDto sDto = new StudentDto();
				sDto.setId(student.getId());
				sDto.setFirstName(student.getFirstName());
				sDto.setLastName(student.getLastName());
				sDto.setBirthDate(student.getBirthDate());
				studentsDto.add(sDto);
			}
		);
		return studentsDto;
	}

	@GetMapping("/studentarray")
	public List<String> studentarray() {
		Iterable<Student> studentEntities = studentRepository.findAll();
		List<String> studentsDto = new ArrayList<>();
		studentEntities.forEach( student -> {
					studentsDto.add(student.getLastName() + ", " + student.getFirstName());
				}
		);
		return studentsDto;
	}
	@PostMapping("/student/create")
	public ResponseEntity createStudent(@RequestBody StudentDto studentDto) {
		Student student = new Student(studentDto.getFirstName(), studentDto.getLastName(), studentDto.getBirthDate());
		studentRepository.save(student);
		return ResponseEntity.ok().build();
	}

   // LK 21.03.2022
	// einzelnen Studenten löschen; delete single student after finding him/her by ID
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity deleteStudent(@PathVariable("id") Long studentId) {
		Student student = studentRepository.findById(studentId).get();
		studentRepository.delete(student);
	// what shall be returned?? LK
	//	return ResponseEntity.ok().delete();
	//	return studentsDto;
		return ResponseEntity.ok().build();
	}



}
