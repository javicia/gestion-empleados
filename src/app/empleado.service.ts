import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Empleado } from './empleado';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  //URL que obtiene el listado de todos los empleados en el backend
  private baseURL = "http://localhost:8080/api/v1/empleados"

  constructor( private httpClient: HttpClient) { }

  //Metodo para obtener los empleados
  obtenerListaEmpleados(): Observable<Empleado[]>{
  return this.httpClient.get<Empleado[]>(`${this.baseURL}`);
}

//Método para registrar un empleado
registrarEmpleado(empleado:Empleado): Observable<Object>{
return this.httpClient.post(`${this.baseURL}`, empleado);
}
}
