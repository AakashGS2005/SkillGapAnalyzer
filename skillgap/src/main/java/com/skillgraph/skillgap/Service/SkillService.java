package com.skillgraph.skillgap.Service;

import org.springframework.stereotype.Service;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Record;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class SkillService {
    private final Driver driver;

    public SkillService(Driver driver) {
        this.driver = driver;
    }

    public List<String> getCareers(String name) {
        try (Session session = driver.session()) {
            return session.run(
                    "MATCH (p:Person {name:$name})-[:HAS_SKILL]->(:Skill)-[:REQUIRED_FOR]->(c:Career) " +
                            "RETURN DISTINCT c.name",
                    Map.of("name", name)
            ).list(r -> r.get("c.name").asString());
        }
    }
}
