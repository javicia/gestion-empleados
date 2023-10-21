import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';
import { Observable } from 'rxjs';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-lista-empleados',
  templateUrl: './lista-empleados.component.html',
  styleUrls: ['./lista-empleados.component.css']
})
export class ListaEmpleadosComponent implements OnInit {

  empleados:Empleado[];

constructor(private empleadoService: EmpleadoService, private router:Router){}

  ngOnInit(): void {
    this.obtenerEmpleados();
    throw new Error('Method not implemented.');
  }

  actualizarEmpleado(id:number){
    this.router.navigate(['actualizar-empleado', id]);
  }

  //Método para eliminar empleado
  eliminarEmpleado(id:number){
     this.empleadoService.eliminarEmpleado(id).subscribe(dato =>{
      console.log(dato) 
      this.obtenerEmpleados();
    })
  }

  //Método para obtener todos los empleados
  private obtenerEmpleados(){
    this.empleadoService.obtenerListaEmpleados().subscribe(dato =>{
     this.empleados= dato 
    });
  }
    //Método para ver los detalles del empleado
    verDetallesDelEmpleado(id:number){
    this.router.navigate(['empleado-detalles', id]);
    }
  }

  

  

  

