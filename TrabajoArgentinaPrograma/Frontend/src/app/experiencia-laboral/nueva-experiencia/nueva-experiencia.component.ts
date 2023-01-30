import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExperienciaLaboral } from 'src/app/model/experiencia-laboral';
import { ServiceExperienciaLaboralService } from 'src/app/service/service-experiencia-laboral.service';

@Component({
  selector: 'app-nueva-experiencia',
  templateUrl: './nueva-experiencia.component.html',
  styleUrls: ['./nueva-experiencia.component.css']
})
export class NuevaExperienciaComponent implements OnInit {
  nombreExp:string = '';
  descripcionExp:string = '';

  constructor(private serviceexperiencia: ServiceExperienciaLaboralService, private router:Router) { }

  ngOnInit(): void {
    
  }

  crearExperiencia(): void{
    const expe = new ExperienciaLaboral(this.nombreExp, this.descripcionExp);
    this.serviceexperiencia.save(expe).subscribe(data=>{
      alert("Experiencia Laboral agregada");
      this.router.navigate(['']);
    }, err =>{alert("Error al cargar Experiencia Laboral");
    this.router.navigate(['']);
   }
   )
  }

}
