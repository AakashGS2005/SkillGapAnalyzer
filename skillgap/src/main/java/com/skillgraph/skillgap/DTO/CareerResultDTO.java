package com.skillgraph.skillgap.DTO;

import java.util.List;

public class CareerResultDTO {

    private List<String> frameworks;
    private List<String> courses;

    public CareerResultDTO(List<String> frameworks, List<String> courses) {
        this.frameworks = frameworks;
        this.courses = courses;
    }

    public List<String> getFrameworks() {
        return frameworks;
    }

    public List<String> getCourses() {
        return courses;
    }
}
