package dev.wcs.sea.trainingplanner.controller;

import dev.wcs.sea.trainingplanner.controller.dto.StudentDto;
import dev.wcs.sea.trainingplanner.controller.dto.TrainingDto;
import dev.wcs.sea.trainingplanner.persistence.entities.Student;
import dev.wcs.sea.trainingplanner.persistence.entities.Training;
import dev.wcs.sea.trainingplanner.persistence.repo.TrainingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainingController {

    private final TrainingRepository trainingRepository;

    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;

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
                    sDto.setTitle(training.getTitle());
                    sDto.setStartDate(training.getStartDate());

                    trainingsDto.add(sDto);
                }
        );
        return trainingsDto;
    }

// analog zu student   LK 09.03.2022

    @PostMapping("/training/create")
    public ResponseEntity createTraining(@RequestBody TrainingDto trainingDto) {
        Training training = new Training(trainingDto.getTitle(), trainingDto.getStartDate());
        trainingRepository.save(training);
        return ResponseEntity.ok().build();
    }


}