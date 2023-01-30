import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExperienciaLaboral } from 'src/app/model/experiencia-laboral';
import { ServiceExperienciaLaboralService } from 'src/app/service/service-experiencia-laboral.service';

@Component({
  selector: 'app-editar-experiencia-laboral',
  templateUrl: './editar-experiencia-laboral.component.html',
  styleUrls: ['./editar-experiencia-laboral.component.css']
})
export class EditarExperienciaLaboralComponent implements OnInit {
  expLaboral:ExperienciaLaboral = null;

  constructor(private servicioExperiencia: ServiceExperienciaLaboralService, private activatedRoute:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.servicioExperiencia.detail(id).subscribe(
      data =>{
        this.expLaboral=data;
      }, err =>{
      alert("Error al editar Experiencia Laboral");
      this.router.navigate(['']);
    }
    )
  }

  actualizarExperiencia(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.servicioExperiencia.update(id, this.expLaboral).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("Error al editar Experiencia Laboral");
        this.router.navigate(['']);
      }
    )
  }

}
