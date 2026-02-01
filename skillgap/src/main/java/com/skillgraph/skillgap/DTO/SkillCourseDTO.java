package com.skillgraph.skillgap.DTO;

public class SkillCourseDTO {

    private String skill;
    private String course;

    public SkillCourseDTO(String skill, String course) {
        this.skill = skill;
        this.course = course;
    }

    public String getSkill() {
        return skill;
    }

    public String getCourse() {
        return course;
    }
}

