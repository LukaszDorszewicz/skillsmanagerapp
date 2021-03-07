package dorszewicz.lukasz.skillsapp.service;

import dorszewicz.lukasz.skillsapp.exception.SkillNotFoundException;
import dorszewicz.lukasz.skillsapp.model.Skill;
import dorszewicz.lukasz.skillsapp.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> findAllSkills() {
        return skillRepository.findAll();
    }

    public Skill updateSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public void deleteSkill(String id) {
        skillRepository.deleteById(id);
    }

    public Skill findSkillById(String id) {
        return skillRepository.findById(id).orElseThrow(() -> new SkillNotFoundException("Skill with id: " + id + " was not found"));
    }
}
