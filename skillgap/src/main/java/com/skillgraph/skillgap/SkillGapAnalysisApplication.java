package com.skillgraph.skillgap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.skillgraph.skillgap.Repository")
public class SkillGapAnalysisApplication {

	public static void main(String[] args) {

		SpringApplication.run(SkillGapAnalysisApplication.class, args);
	}

}
