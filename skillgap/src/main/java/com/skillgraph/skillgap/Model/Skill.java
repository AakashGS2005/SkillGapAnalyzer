package com.skillgraph.skillgap.Model;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;

@Node("Skill")
public class Skill {

    @Id
    private String name;

    public Skill() {}

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
