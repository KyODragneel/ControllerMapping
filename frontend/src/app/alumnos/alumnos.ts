import { Component, OnInit, inject, signal } from '@angular/core';
import { Alumno, AlumnoDto } from '../alumno';

@Component({
  selector: 'app-alumnos',
  imports: [],
  templateUrl: './alumnos.html',
  styleUrl: './alumnos.css',
})
export class Alumnos implements OnInit {
  private alumnoService = inject(Alumno);
  alumnos = signal<AlumnoDto[]>([]);

  ngOnInit(): void {
    this.alumnoService.getAlumnos().subscribe((data) => this.alumnos.set(data));
  }
}