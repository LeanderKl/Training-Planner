package dev.wcs.sea.trainingplanner.entities;

import java.time.LocalDate;
import java.util.List;

public class Training {

    private Long id;

    private String title;
    private LocalDate startDate;
    private List<Student> students;

    public Training(Long id, String title, LocalDate startDate) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
