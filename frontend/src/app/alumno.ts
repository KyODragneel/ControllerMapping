import { Service, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface AlumnoDto {
  id: number;
  nombre: string;
  carrera: string;
}

@Service()
export class Alumno {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/alumnos';

  getAlumnos(): Observable<AlumnoDto[]> {
    return this.http.get<AlumnoDto[]>(this.apiUrl);
  }
}