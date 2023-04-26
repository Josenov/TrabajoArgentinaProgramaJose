import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skills } from 'src/app/model/skills';
import { SkillsService } from 'src/app/service/skills.service';

@Component({
  selector: 'app-nuevo-skill',
  templateUrl: './nuevo-skill.component.html',
  styleUrls: ['./nuevo-skill.component.css']
})
export class NuevoSkillComponent implements OnInit {

  nombre:string;
  porcentaje:number;


  constructor(private serviceSkills:SkillsService, private router:Router) { }

  ngOnInit(): void {
  }


  crearSkill(): void{
    const skill = new Skills(this.nombre, this.porcentaje);
    this.serviceSkills.save(skill).subscribe(data=>{
      alert("Skill agregada");
      this.router.navigate(['']);
    }, err =>{alert("Error al cargar Skill");
    this.router.navigate(['']);
   }
   )
  }

}
