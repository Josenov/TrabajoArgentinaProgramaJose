import { Component, OnInit } from '@angular/core';
import { ExperienciaLaboral } from '../model/experiencia-laboral';
import { ServiceExperienciaLaboralService } from '../service/service-experiencia-laboral.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-experiencia-laboral',
  templateUrl: './experiencia-laboral.component.html',
  styleUrls: ['./experiencia-laboral.component.css']
})
export class ExperienciaLaboralComponent implements OnInit {
  experienciaLaboral:ExperienciaLaboral[]=[];

  constructor(private serviceExperienciaLaboral:ServiceExperienciaLaboralService,private tokenService:TokenService ) { }

  ngOnInit(): void {
    this.cargarExpLaboral();
    if(this.tokenService.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;

    }

    
  }

  isLogged=false;


  cargarExpLaboral():void{
    this.serviceExperienciaLaboral.lista().subscribe(data =>{this.experienciaLaboral = data;})
  }

  borrar(id?:number){
    if(id != undefined){
      this.serviceExperienciaLaboral.delete(id).subscribe(
        data =>{
          this.cargarExpLaboral();
        }, err =>{
          alert("No se pudo eliminar Experiencia Laboral");
        }

        
      )
    }
  }

}
