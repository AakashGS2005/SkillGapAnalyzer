package com.skillgraph.skillgap.Model;





import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Career")
public class Career {

    @Id
    private String name;

    public Career() {}

    public Career(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}




