package com.skillgraph.skillgap.Controller;

import com.skillgraph.skillgap.Service.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@RestController
@CrossOrigin
public class SkillController {
    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping("/careers/{name}")
    public List<String> careers(@PathVariable String name) {
        return service.getCareers(name);
    }
    @GetMapping("/careers/test")
    public String testCareers() {
        return "Careers endpoint works";
    }

}
