package dev.wcs.sea.trainingplanner.controller;

import dev.wcs.sea.trainingplanner.controller.dto.StudentDto;
import dev.wcs.sea.trainingplanner.controller.dto.TrainingDto;
import dev.wcs.sea.trainingplanner.persistence.entities.Student;
import dev.wcs.sea.trainingplanner.persistence.entities.Training;
import dev.wcs.sea.trainingplanner.persistence.repo.StudentRepository;
import dev.wcs.sea.trainingplanner.persistence.repo.TrainingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainingController {

    private final TrainingRepository trainingRepository;
    private final StudentRepository studentRepository;

    public TrainingController(TrainingRepository trainingRepository, StudentRepository studentRepository) {
        this.trainingRepository = trainingRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/training_static")
    public List<Training> trainings() {
        List<Training> trainings  = new ArrayList<>();
        Training training1;
        training1 = new Training("Training1", LocalDate.now());
        trainings.add(training1);

        return trainings;
}
    @GetMapping("/training")
    public List<TrainingDto> training() {
// analog zu student   LK 04.03.2022

        Iterable<Training> trainingEntities = trainingRepository.findAll();
        List<TrainingDto> trainingsDto = new ArrayList<>();
        trainingEntities.forEach(training -> {
                    TrainingDto sDto = new TrainingDto();
                    sDto.setId(training.getId());
                    sDto.setTitle(training.getTitle());
                    sDto.setStartDate(training.getStartDate());
                    for (Student student : training.getStudents()) {
                        StudentDto studentDto = new StudentDto();
                        studentDto.setId(student.getId());
                        studentDto.setBirthDate(student.getBirthDate());
                        studentDto.setLastName(student.getLastName());
                        studentDto.setFirstName(student.getFirstName());
                        sDto.getStudents().add(studentDto);
                    }
                    trainingsDto.add(sDto);
                }
        );
        return trainingsDto;
    }
    // zus??tzlicher (additioal) endpoint analog zu studentarray in StudentController.java   LK 22.04.2022@GetMapping("/studentarray")
    //	public List<String> studentarray() {
    //		Iterable<Student> studentEntities = studentRepository.findAll();
    //		List<String> studentsDto = new ArrayList<>();
    //		studentEntities.forEach( student -> {
    //					studentsDto.add(student.getLastName() + ", " + student.getFirstName());
    //				}
    //		);
    //		return studentsDto;



    @GetMapping("/trainingarray")
    public List<String> trainingarray() {
        Iterable<Training> trainingEntities = trainingRepository.findAll();
        List<String> trainingsDto = new ArrayList<>();
        trainingEntities.forEach(training -> {
                    trainingsDto.add(training.getTitle() + ", " + training.getStartDate());
                }
        );
        return trainingsDto;
// analog zu student   LK 09.03.2022
    }



    @PostMapping("/training/create")
    public ResponseEntity createTraining(@RequestBody TrainingDto trainingDto) {
        Training training = new Training(trainingDto.getTitle(), trainingDto.getStartDate());
        trainingRepository.save(training);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/training/{trainingId}/assignStudent/{studentId}")
    public ResponseEntity createTraining(@PathVariable Long trainingId, @PathVariable Long studentId) {
        // Use trainingRepository to find the training by Id
        //18.03.2022 done by LK as follows next line
        Training training = trainingRepository.findById(trainingId).get();
        // Use studentRepository to find student by Id
        //18.03.2022 done by LK as follows next line
        Student student = studentRepository.findById(studentId).get();
        // Use getStudents method on training to add the student
        //18.03.2022 done whats written above by LK
        training.getStudents().add(student);
        // Call trainingRepository with save to store updated training
        //18.03.2022 done by LK as follows next line
        trainingRepository.save(training);


        return ResponseEntity.ok().build();
    }

// LK 21.03.2022
    // einzelnes Training l??schen; delete single training after finding it by ID
	/*@PostMapping("/training/delete")
	public ResponseEntity deleteTraining(@RequestBody TrainingDto trainingDto) {

	Training training = trainingRepository.findById(trainingId);
		trainingRepository.delete(training);
		return ResponseEntity.ok().delete();
	}

	*/

}