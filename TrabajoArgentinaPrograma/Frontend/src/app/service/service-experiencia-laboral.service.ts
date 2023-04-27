import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExperienciaLaboral } from '../model/experiencia-laboral';

@Injectable({
  providedIn: 'root'
})
export class ServiceExperienciaLaboralService {
  expURL="https://portfoliobackend-8ce5.onrender.com/explab/"

  constructor(private httpClient:HttpClient) { }

  public lista(): Observable<ExperienciaLaboral[]>{
    return this.httpClient.get<ExperienciaLaboral[]>(this.expURL + 'lista');
   
  }

  public detail(id:number): Observable<ExperienciaLaboral>{
    return this.httpClient.get<ExperienciaLaboral>(this.expURL + `detail/${id}`);
  }

  public save(explaboral:ExperienciaLaboral): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', explaboral);

  }

  public update(id: number, explaboral:ExperienciaLaboral): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, explaboral);

  }

  public delete(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);

  }
}
