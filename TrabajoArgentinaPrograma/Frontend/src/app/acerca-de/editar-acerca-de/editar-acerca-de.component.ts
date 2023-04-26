import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { ImgService } from 'src/app/service/img.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-editar-acerca-de',
  templateUrl: './editar-acerca-de.component.html',
  styleUrls: ['./editar-acerca-de.component.css']
})
export class EditarAcercaDeComponent implements OnInit {

  persona:persona=null;

  constructor(private servicePersona:PersonaService, private activatedRoute:ActivatedRoute, private router:Router, public imgService:ImgService) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.servicePersona.detail(id).subscribe(
      data =>{
        this.persona=data;
      }, err =>{
      alert("Error al editar Usuario");
      this.router.navigate(['']);
    }
    )
  }

  actualizarPersona():void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.persona.img = this.imgService.url;
    this.servicePersona.update(id, this.persona).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("Error al editar Usuario");
        this.router.navigate(['']);
      }
    )
  }


  subirImagen($event:any){
    const id = this.activatedRoute.snapshot.params['id'];
    const name = "fotoperfil_" + id;
    this.imgService.subirImagen($event, name)
    
  }

}
