import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skills } from 'src/app/model/skills';
import { SkillsService } from 'src/app/service/skills.service';

@Component({
  selector: 'app-editar-skills',
  templateUrl: './editar-skills.component.html',
  styleUrls: ['./editar-skills.component.css']
})
export class EditarSkillsComponent implements OnInit {
  skill:Skills = null;

  constructor(private serviceSkills:SkillsService, private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serviceSkills.detail(id).subscribe(
      data =>{
        this.skill=data;
      }, err =>{
      alert("Error al editar Skill");
      this.router.navigate(['']);
    }
    )
  }

  actualizarSkill(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.serviceSkills.update(id, this.skill).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("Error al editar Skill");
        this.router.navigate(['']);
      }
    )
  }

}
