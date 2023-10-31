import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-actualizar-empleado',
  templateUrl: './actualizar-empleado.component.html',
  styleUrls: ['./actualizar-empleado.component.css']
})
export class ActualizarEmpleadoComponent implements OnInit{
  id:number;
  empleado:Empleado = new Empleado();

  constructor(private empleadoService:EmpleadoService, private router:Router, private route:ActivatedRoute){}
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.empleadoService.obtenerEmpleadoPorId(this.id).subscribe (dato =>{
this.empleado = dato;
},error => console.log(error));
    
    throw new Error('Method not implemented.');
  }
  

  irListaEmpleados(){
    this.router.navigate(['/empleados'])
    //swal('Empleado actualizado',`El empleado ${this.empleado.nombre} ha sido actualizado con exito`,`success`);
  }

  onSubmit(){
    this.empleadoService.actualizarEmpleado(this.id, this.empleado).subscribe(dato=>{
      this.irListaEmpleados();
    },error => console.log(error));
  }
}

