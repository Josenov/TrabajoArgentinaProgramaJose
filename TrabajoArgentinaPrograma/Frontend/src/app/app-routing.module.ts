import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarExperienciaLaboralComponent } from './experiencia-laboral/editar-experiencia-laboral/editar-experiencia-laboral.component';
import { NuevaExperienciaComponent } from './experiencia-laboral/nueva-experiencia/nueva-experiencia.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexperiencialaboral', component: NuevaExperienciaComponent },
  {path:'editarexperiencialaboral/:id', component: EditarExperienciaLaboralComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
