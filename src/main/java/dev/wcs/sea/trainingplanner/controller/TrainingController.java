package dev.wcs.sea.trainingplanner.controller;
import dev.wcs.sea.trainingplanner.persistence.entities.Training;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainingController {


    @GetMapping("/training")
    public List<Training> trainings() {
        List<Training> trainings  = new ArrayList<>();
        Training training1;
        training1 = new Training("Training1", LocalDate.now());
        trainings.add(training1);

        return trainings;
}
}