import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoDetallesComponent } from './empleado-detalles.component';

describe('EmpleadoDetallesComponent', () => {
  let component: EmpleadoDetallesComponent;
  let fixture: ComponentFixture<EmpleadoDetallesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmpleadoDetallesComponent]
    });
    fixture = TestBed.createComponent(EmpleadoDetallesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
