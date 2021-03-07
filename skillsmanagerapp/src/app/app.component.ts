import {Component, OnInit} from '@angular/core';
import {Skill} from './skill';
import {SkillService} from './skill.service';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public skills: Skill[];
  public editSkill: Skill;
  public deleteSkill: Skill;

  constructor(private skillService: SkillService) {
  }

  ngOnInit() {
    this.getSkills();
  }

  public getSkills(): void {
    this.skillService.getSkills().subscribe(
      (response: Skill[]) => {
        this.skills = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddSkill(addSkill: NgForm): void {
    this.skillService.addSkill(addSkill.value).subscribe(
      (response: Skill) => {
        console.log(response);
        this.getSkills();
        addSkill.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateSkill(skill: Skill): void {
    this.skillService.updateSkill(skill).subscribe(
      (response: Skill) => {
        console.log(response);
        this.getSkills();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteSkill(skillId: string): void {
    this.skillService.deleteSkill(skillId).subscribe(
      (response: void) => {
        console.log(response);
        this.getSkills();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchSkills(key: string): void {
    console.log(key);
    const results: Skill[] = [];
    for (const skill of this.skills) {
      if (skill.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || skill.skillLevel.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(skill);
      }
    }
    this.skills = results;
    if (results.length === 0 || !key) {
      this.getSkills();
    }
  }

  public onOpenModal(skill: Skill, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addSkillModal');
    }
    if (mode === 'edit') {
      this.editSkill = skill;
      button.setAttribute('data-target', '#updateSkillModal');
    }
    if (mode === 'delete') {
      this.deleteSkill = skill;
      button.setAttribute('data-target', '#deleteSkillModal');
    }
    container.appendChild(button);
    button.click();
  }
}
