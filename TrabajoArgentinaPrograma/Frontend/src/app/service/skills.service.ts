import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skills } from '../model/skills';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SkillsService {

  skillURL = "https://portfoliobackend-8ce5.onrender.com/skills/"

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Skills[]> {
    return this.httpClient.get<Skills[]>(this.skillURL + 'lista');

  }

  public detail(id: number): Observable<Skills> {
    return this.httpClient.get<Skills>(this.skillURL + `detail/${id}`);
  }

  public save(skills: Skills): Observable<any> {
    return this.httpClient.post<any>(this.skillURL + 'create', skills);

  }

  public update(id: number, skills: Skills): Observable<any> {
    return this.httpClient.put<any>(this.skillURL + `update/${id}`, skills);

  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.skillURL + `delete/${id}`);

  }
}
