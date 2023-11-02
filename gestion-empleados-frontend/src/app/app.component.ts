import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http: HttpClient) {}

  title = 'Sistema gestión de empleados';
  departamentos: any;

  buscarEmpleado(termino: string) {
    this.http.get(`/api/v1/empleados-detalles/${termino}`).subscribe(
      (response: any) => {
        // Maneja la respuesta del backend, como mostrar los detalles del empleado en el componente EmpleadoDetallesComponent.
      },
    );
  }
}
