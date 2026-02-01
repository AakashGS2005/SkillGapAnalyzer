package com.skillgraph.skillgap.Controller;



import com.skillgraph.skillgap.DTO.CareerPathDTO;
import com.skillgraph.skillgap.Service.CareerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/career")
@CrossOrigin(origins = "*")
public class CareerController {

    private final CareerService service;

    public CareerController(CareerService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllCareers() {
        return service.getAllCareers();
    }

    @GetMapping("/{career}/skills")
    public List<String> getSkillsByCareer(@PathVariable String career) {
        return service.getSkillsByCareer(career);
    }

    @GetMapping("/path")
    public CareerPathDTO getRecommendedPath(
            @RequestParam String career,
            @RequestParam String skill) {
        return service.getRecommendedPath(career, skill);
    }
}
