package com.skillgraph.skillgap.DTO;



import java.util.List;

public class CareerPathDTO {

    private String skill;
    private List<String> frameworks;
    private List<String> courses;

    public CareerPathDTO(String skill, List<String> frameworks, List<String> courses) {
        this.skill = skill;
        this.frameworks = frameworks;
        this.courses = courses;
    }

    // getters & setters

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public List<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(List<String> frameworks) {
        this.frameworks = frameworks;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}

