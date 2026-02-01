package com.skillgraph.skillgap.DTO;

import java.util.List;

public class FrameworkCourseDTO {

    private String framework;
    private List<String> courses;

    public FrameworkCourseDTO(String framework, List<String> courses) {
        this.framework = framework;
        this.courses = courses;
    }

    public String getFramework() {
        return framework;
    }

    public List<String> getCourses() {
        return courses;
    }
}
