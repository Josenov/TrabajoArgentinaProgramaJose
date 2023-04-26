import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormacionAcademica } from 'src/app/model/formacion-academica';
import { FormacionAcademicaService } from 'src/app/service/formacion-academica.service';

@Component({
  selector: 'app-editar-formacion-academica',
  templateUrl: './editar-formacion-academica.component.html',
  styleUrls: ['./editar-formacion-academica.component.css']
})
export class EditarFormacionAcademicaComponent implements OnInit {
  formAcademica : FormacionAcademica = null;

  constructor(private serviceFormacionAcademica: FormacionAcademicaService, private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serviceFormacionAcademica.detail(id).subscribe(
      data =>{
        this.formAcademica=data;
      }, err =>{
      alert("Error al editar Formacion Academica");
      this.router.navigate(['']);
    }
    )
  }

  actualizarFormAcademica(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.serviceFormacionAcademica.update(id, this.formAcademica).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("Error al editar Formacion Academica");
        this.router.navigate(['']);
      }
    )
  }

}
