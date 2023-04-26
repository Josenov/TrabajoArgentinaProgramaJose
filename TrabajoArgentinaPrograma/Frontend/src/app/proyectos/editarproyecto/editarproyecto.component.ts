import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyectos } from 'src/app/model/proyectos';
import { ImgService } from 'src/app/service/img.service';
import { ProyectosService } from 'src/app/service/proyectos.service';

@Component({
  selector: 'app-editarproyecto',
  templateUrl: './editarproyecto.component.html',
  styleUrls: ['./editarproyecto.component.css']
})
export class EditarproyectoComponent implements OnInit {

  proyectos:Proyectos=null;

  constructor(private activatedRoute:ActivatedRoute, private proyectosService:ProyectosService, private router:Router, public imgService: ImgService) { }

  ngOnInit(): void {
    const id=this.activatedRoute.snapshot.params['id'];
    this.proyectosService.detail(id).subscribe(
      data => {
        this.proyectos=data;
      }, err=>{
        alert(" Error al editar Proyecto");
        this.router.navigate(['']);
      }
    )

  }

  EditarProyectos():void{
    const id=this.activatedRoute.snapshot.params['id'];
    this.proyectos.imgProyecto=this.imgService.url;
    this.proyectosService.update(id, this.proyectos).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err=>{
        alert(" Error al editar Proyecto");
        this.router.navigate(['']);


      }
    )
  }

  subirImagenProyecto($event:any){
    const id = this.activatedRoute.snapshot.params['id'];
    const nombre = 'fotoproyecto_' + id;
    this.imgService.subirImagen($event, nombre)
    
  }

}
