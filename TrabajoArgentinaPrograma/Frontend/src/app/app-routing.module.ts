import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarAcercaDeComponent } from './acerca-de/editar-acerca-de/editar-acerca-de.component';
import { EditarExperienciaLaboralComponent } from './experiencia-laboral/editar-experiencia-laboral/editar-experiencia-laboral.component';
import { NuevaExperienciaComponent } from './experiencia-laboral/nueva-experiencia/nueva-experiencia.component';
import { EditarFormacionAcademicaComponent } from './formacion-academica/editar-formacion-academica/editar-formacion-academica.component';
import { NuevaFormacionComponent } from './formacion-academica/nueva-formacion/nueva-formacion.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { EditarSkillsComponent } from './skills/editar-skills/editar-skills.component';
import { NuevoSkillComponent } from './skills/nuevo-skill/nuevo-skill.component';
import { EditarproyectoComponent } from './proyectos/editarproyecto/editarproyecto.component';
import { NuevoproyectoComponent } from './proyectos/nuevoproyecto/nuevoproyecto.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexperiencialaboral', component: NuevaExperienciaComponent },
  {path:'editarexperiencialaboral/:id', component: EditarExperienciaLaboralComponent},
  {path:'nuevaformacionacademica', component: NuevaFormacionComponent },
  {path:'editarformacionacademica/:id', component: EditarFormacionAcademicaComponent},
  {path:'nuevoskill', component: NuevoSkillComponent },
  {path:'editarskill/:id', component: EditarSkillsComponent},
  {path:'editaracercade/:id', component: EditarAcercaDeComponent},
  {path:'nuevoproyecto', component: NuevoproyectoComponent },
  {path:'editarproyecto/:id', component: EditarproyectoComponent}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
