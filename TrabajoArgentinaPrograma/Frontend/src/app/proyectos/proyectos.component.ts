import { Component, OnInit } from '@angular/core';
import { Proyectos } from '../model/proyectos';
import { ProyectosService } from '../service/proyectos.service';
import { TokenService } from '../service/token.service';
import { ImgService } from '../service/img.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  proyectos: Proyectos[] = [];

  isLogged = false;

  constructor(private proyectosService: ProyectosService, private tokenService: TokenService, public imgService: ImgService) { }

  ngOnInit(): void {
    this.cargarProyecto();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProyecto(): void {
    this.proyectosService.lista().subscribe(
      data => {
        this.proyectos = data;
      }
    )
  }

  borrar(id?: number) {
    if (id != undefined) {
      this.proyectosService.delete(id).subscribe(
        data => {
          this.cargarProyecto();
        }, err => {
          alert("No se pudo eliminar Proyecto")
        }
      )

    }
  }

}
