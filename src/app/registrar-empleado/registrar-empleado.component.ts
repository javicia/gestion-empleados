import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-registrar-empleado',
  templateUrl: './registrar-empleado.component.html',
  styleUrls: ['./registrar-empleado.component.css']
})
export class RegistrarEmpleadoComponent implements OnInit{

  empleado: Empleado = new Empleado();

  constructor(private empleadoService: EmpleadoService, private router:Router){}

  ngOnInit(): void {
    console.log(this.empleado);

    throw new Error('Method not implemented.');
  }

  guardarEmpleado(){
    this.empleadoService.registrarEmpleado(this.empleado).subscribe(dato =>{
      console.log(dato);
    this.irListaEmpleados();
    }, error => console.log(error));
  }

  irListaEmpleados(){
    this.router.navigate(['/empleados'])
  }
  onSubmit(){
   this.guardarEmpleado();
  }

}
