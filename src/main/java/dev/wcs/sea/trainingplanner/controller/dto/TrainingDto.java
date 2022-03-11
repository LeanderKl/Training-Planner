package dev.wcs.sea.trainingplanner.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainingDto {

    private Long id;
    private String title;
    private LocalDate startDate;
    private List<StudentDto> students = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

}
