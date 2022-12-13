import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LogoArgProgramaComponent } from './logo-arg-programa/logo-arg-programa.component';
import { RedessocialesComponent } from './redessociales/redessociales.component';
import { BannerComponent } from './banner/banner.component';
import { AcercaDeComponent } from './acerca-de/acerca-de.component';
import { ExperienciaLaboralComponent } from './experiencia-laboral/experiencia-laboral.component';
import { FormacionAcademicaComponent } from './formacion-academica/formacion-academica.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoArgProgramaComponent,
    RedessocialesComponent,
    BannerComponent,
    AcercaDeComponent,
    ExperienciaLaboralComponent,
    FormacionAcademicaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
