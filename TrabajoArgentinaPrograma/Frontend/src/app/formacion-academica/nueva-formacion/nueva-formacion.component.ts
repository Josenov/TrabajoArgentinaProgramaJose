import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormacionAcademica } from 'src/app/model/formacion-academica';
import { FormacionAcademicaService } from 'src/app/service/formacion-academica.service';

@Component({
  selector: 'app-nueva-formacion',
  templateUrl: './nueva-formacion.component.html',
  styleUrls: ['./nueva-formacion.component.css']
})
export class NuevaFormacionComponent implements OnInit {

  nombreForm:string = '';
  descripcionForm:string = '';

  constructor(private serviceFormAcademica:FormacionAcademicaService, private router:Router) { }

  ngOnInit(): void {
  }

  crearFormAcademica(): void{
    const formacion = new FormacionAcademica(this.nombreForm, this.descripcionForm);
    this.serviceFormAcademica.save(formacion).subscribe(data=>{
      alert("Formacion Academica agregada");
      this.router.navigate(['']);
    }, err =>{alert("Error al cargar Formacion Academica");
    this.router.navigate(['']);
   }
   )
  }

}
