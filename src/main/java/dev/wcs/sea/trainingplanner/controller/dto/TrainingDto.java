package dev.wcs.sea.trainingplanner.controller.dto;

import java.time.LocalDate;

public class TrainingDto {

    private String title;
    private LocalDate startDate;

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

}
