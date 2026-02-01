package com.skillgraph.skillgap.Service;


import com.skillgraph.skillgap.DTO.CareerPathDTO;
import com.skillgraph.skillgap.DTO.CareerResultDTO;
import com.skillgraph.skillgap.Repository.CareerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.skillgraph.skillgap.DTO.CareerResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CareerService {

    private final CareerRepository repo;

    public CareerService(CareerRepository repo) {
        this.repo = repo;
    }

    public List<String> getAllCareers() {
        return repo.findAllCareerNames();
    }

    public List<String> getSkillsByCareer(String career) {
        return repo.findSkillsByCareer(career);
    }

    public CareerPathDTO getRecommendedPath(String career, String skill) {
        return repo.findFrameworksAndCourses(career, skill);
    }

}
