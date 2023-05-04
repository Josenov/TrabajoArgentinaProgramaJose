import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FormacionAcademica } from '../model/formacion-academica';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})


export class FormacionAcademicaService {

  formURL = environment.URL + "formacionacademica/"

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<FormacionAcademica[]> {
    return this.httpClient.get<FormacionAcademica[]>(this.formURL + 'lista');

  }

  public detail(id: number): Observable<FormacionAcademica> {
    return this.httpClient.get<FormacionAcademica>(this.formURL + `detail/${id}`);
  }

  public save(formacionacademica: FormacionAcademica): Observable<any> {
    return this.httpClient.post<any>(this.formURL + 'create', formacionacademica);

  }

  public update(id: number, formacionacademica: FormacionAcademica): Observable<any> {
    return this.httpClient.put<any>(this.formURL + `update/${id}`, formacionacademica);

  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.formURL + `delete/${id}`);

  }
}
