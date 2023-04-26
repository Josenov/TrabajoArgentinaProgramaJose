import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyectos } from 'src/app/model/proyectos';
import { ImgService } from 'src/app/service/img.service';
import { ProyectosService } from 'src/app/service/proyectos.service';

@Component({
  selector: 'app-nuevoproyecto',
  templateUrl: './nuevoproyecto.component.html',
  styleUrls: ['./nuevoproyecto.component.css']
})
export class NuevoproyectoComponent implements OnInit {

  nombreProyecto:string;
  descripcionProyecto:string;
  urlProyecto:string;
  imgProyecto:string;

  constructor(private proyectosService:ProyectosService, private router:Router, private activatedRoute:ActivatedRoute, public imgService:ImgService) { }

  ngOnInit(): void {
  }


  CrearProyecto(): void{
    const proyectos = new Proyectos(this.nombreProyecto, this.descripcionProyecto, this.urlProyecto, this.imgProyecto );
    this.proyectosService.save(proyectos).subscribe(
      data =>{
        alert("Proyecto añadido correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("Error al cargar Proyecto");
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
