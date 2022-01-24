package dev.wcs.sea.trainingplanner;

import dev.wcs.sea.trainingplanner.entities.Student;
import dev.wcs.sea.trainingplanner.entities.Training;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataModelTests {

    @Test
    public void createTraining() {
        Training tr = new Training(1l, "Training1", LocalDate.now());
        assertEquals(1l, tr.getId());
        assertEquals("Training1", tr.getTitle());
        assertEquals(LocalDate.now(), tr.getStartDate());
    }

    @Test
    public void createStudent() {
        Student st = new Student(1l, "Vorname", "Nachname", LocalDate.now().minusYears(30));
        assertEquals(1l, st.getId());
        assertEquals("Vorname", st.getFirstName());
        assertEquals("Nachname", st.getLastName());
        assertEquals(LocalDate.now().minusYears(30), st.getBirthDate());
    }

}
