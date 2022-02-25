package dev.wcs.sea.trainingplanner;

import dev.wcs.sea.trainingplanner.persistence.entities.Student;
import dev.wcs.sea.trainingplanner.persistence.entities.Training;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataModelTests {

    @Test
    public void createTraining() {
        Training tr = new Training( "Training1", LocalDate.now());
        assertEquals("Training1", tr.getTitle());
        assertEquals(LocalDate.now(), tr.getStartDate());
    }

    @Test
    public void createStudent() {
        Student st = new Student("Vorname", "Nachname", LocalDate.now().minusYears(30));
        assertEquals("Vorname", st.getFirstName());
        assertEquals("Nachname", st.getLastName());
        assertEquals(LocalDate.now().minusYears(30), st.getBirthDate());
    }

}
