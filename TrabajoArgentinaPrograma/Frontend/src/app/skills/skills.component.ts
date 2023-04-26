import { Component, OnInit } from '@angular/core';
import { Skills } from '../model/skills';
import { SkillsService } from '../service/skills.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  skill : Skills [] = [];

  constructor(private serviceSkills:SkillsService, private tokenService:TokenService) { }

  isLogged=false;

  ngOnInit(): void {
    this.cargarSkill();
    if(this.tokenService.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;

    }
  }

  cargarSkill():void{
    this.serviceSkills.lista().subscribe(data =>{this.skill = data;})
  }

  borrar(id:number){
    if(id != undefined){
      this.serviceSkills.delete(id).subscribe(
        data =>{
          this.cargarSkill();
        }, err =>{
          alert("No se pudo eliminar Skill");
        }

        
      )
    }
  }

}
