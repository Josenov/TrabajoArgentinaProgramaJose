import { Component, OnInit } from '@angular/core';
import { FormacionAcademica } from '../model/formacion-academica';
import { FormacionAcademicaService } from '../service/formacion-academica.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-formacion-academica',
  templateUrl: './formacion-academica.component.html',
  styleUrls: ['./formacion-academica.component.css']
})
export class FormacionAcademicaComponent implements OnInit {
  formacademica : FormacionAcademica []= [];

  constructor(private serviceFormacionAcademica:FormacionAcademicaService, private tokenService:TokenService) { }
  
  isLogged=false;

  ngOnInit(): void {
    this.cargarFormAcademica();
    if(this.tokenService.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;

    }
  }

  cargarFormAcademica():void{
    this.serviceFormacionAcademica.lista().subscribe(data =>{this.formacademica = data;})
  }

  borrar(id?:number){
    if(id != undefined){
      this.serviceFormacionAcademica.delete(id).subscribe(
        data =>{
          this.cargarFormAcademica();
        }, err =>{
          alert("No se pudo eliminar Formacion Academica");
        }

        
      )
    }
  }

}
