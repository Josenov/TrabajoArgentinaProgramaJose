import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LogoArgProgramaComponent } from './logo-arg-programa/logo-arg-programa.component';
import { RedessocialesComponent } from './redessociales/redessociales.component';
import { BannerComponent } from './banner/banner.component';
import { AcercaDeComponent } from './acerca-de/acerca-de.component';
import { ExperienciaLaboralComponent } from './experiencia-laboral/experiencia-laboral.component';
import { FormacionAcademicaComponent } from './formacion-academica/formacion-academica.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { SkillsComponent } from './skills/skills.component';
import { ProyectosComponent } from './proyectos/proyectos.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClient, HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { interceptorProvider } from './service/interceptorService';
import { NuevaExperienciaComponent } from './experiencia-laboral/nueva-experiencia/nueva-experiencia.component';
import { EditarExperienciaLaboralComponent } from './experiencia-laboral/editar-experiencia-laboral/editar-experiencia-laboral.component';
import { NuevaFormacionComponent } from './formacion-academica/nueva-formacion/nueva-formacion.component';
import { EditarFormacionAcademicaComponent } from './formacion-academica/editar-formacion-academica/editar-formacion-academica.component';
import { EditarSkillsComponent } from './skills/editar-skills/editar-skills.component';
import { NuevoSkillComponent } from './skills/nuevo-skill/nuevo-skill.component';
import { EditarAcercaDeComponent } from './acerca-de/editar-acerca-de/editar-acerca-de.component';
import { initializeApp,provideFirebaseApp } from '@angular/fire/app';
import { environment } from '../environments/environment';
import { provideStorage,getStorage } from '@angular/fire/storage';
import { EditarproyectoComponent } from './proyectos/editarproyecto/editarproyecto.component';
import { NuevoproyectoComponent } from './proyectos/nuevoproyecto/nuevoproyecto.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoArgProgramaComponent,
    RedessocialesComponent,
    BannerComponent,
    AcercaDeComponent,
    ExperienciaLaboralComponent,
    FormacionAcademicaComponent,
    SkillsComponent,
    ProyectosComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    NuevaExperienciaComponent,
    EditarExperienciaLaboralComponent,
    NuevaFormacionComponent,
    EditarFormacionAcademicaComponent,
    EditarSkillsComponent,
    NuevoSkillComponent,
    EditarAcercaDeComponent,
    EditarproyectoComponent,
    NuevoproyectoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    FormsModule,
    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideStorage(() => getStorage())
  ],
  providers:[
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
