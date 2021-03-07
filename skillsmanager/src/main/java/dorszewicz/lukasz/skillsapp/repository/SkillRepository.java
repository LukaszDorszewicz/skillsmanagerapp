package dorszewicz.lukasz.skillsapp.repository;

import dorszewicz.lukasz.skillsapp.model.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillRepository extends MongoRepository<Skill, String> {
}
