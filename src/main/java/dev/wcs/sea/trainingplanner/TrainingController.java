package dev.wcs.sea.trainingplanner;
import dev.wcs.sea.trainingplanner.entities.Training;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TrainingController {


    @GetMapping("/trainings")
    public List<Training> trainings() {
        List<Training> trainings  = new ArrayList<>();
        Training training1;
        training1 = new Training(1L, "Training1", LocalDate.now());
        trainings.add(training1);

        return trainings;
}
}