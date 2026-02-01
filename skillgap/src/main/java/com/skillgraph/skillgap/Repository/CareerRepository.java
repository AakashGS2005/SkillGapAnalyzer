package com.skillgraph.skillgap.Repository;




import com.skillgraph.skillgap.DTO.CareerPathDTO;
import com.skillgraph.skillgap.Model.Career;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface CareerRepository extends Neo4jRepository<Career, String> {

    @Query("MATCH (c:Career) RETURN c.name")
    List<String> findAllCareerNames();

    @Query("""
        MATCH (c:Career {name:$career})-[:REQUIRES_SKILL]->(s:Skill)
        RETURN s.name
    """)
    List<String> findSkillsByCareer(String career);

    @Query("""
MATCH (c:Career {name:$career})-[:REQUIRES_SKILL]->(s:Skill {name:$skill})
MATCH (s)-[:HAS_FRAMEWORK]->(f:Framework)
MATCH (f)-[:HAS_COURSE]->(co:Course)
RETURN s.name AS skill,
       collect(DISTINCT f.name) AS frameworks,
       collect(DISTINCT co.name) AS courses
""")
    CareerPathDTO findFrameworksAndCourses(String career, String skill);

}





