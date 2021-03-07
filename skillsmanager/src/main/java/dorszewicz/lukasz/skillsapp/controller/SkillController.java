package dorszewicz.lukasz.skillsapp.controller;

import dorszewicz.lukasz.skillsapp.model.Skill;
import dorszewicz.lukasz.skillsapp.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.findAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable String id) {
        Skill skill = skillService.findSkillById(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.addSkill(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.updateSkill(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable String id) {
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
