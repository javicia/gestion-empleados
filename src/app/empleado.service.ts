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

//Método para actualizar empleado
actualizarEmpleado(id:number, empleado:Empleado): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${id}`, empleado);
}

//Metodo para obetener o buscar empleado
obtenerEmpleadoPorId(id:number): Observable<Empleado>{
  return this.httpClient.get<Empleado>(`${this.baseURL}/${id}`);
}

//Método para elimnar empleado
eliminarEmpleado(id:number):Observable<Object>{
return this.httpClient.delete(`${this.baseURL}/${id}`);
}

//Método para buscar empleado en el buscador
buscarEmpleado(nombre:string):Observable<Empleado[]>{
  return this.httpClient.get<Empleado[]>(`${this.baseURL}/seach`);
}
}
