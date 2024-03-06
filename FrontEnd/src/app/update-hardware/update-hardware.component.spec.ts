import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateHardwareComponent } from './update-hardware.component';

describe('UpdateHardwareComponent', () => {
  let component: UpdateHardwareComponent;
  let fixture: ComponentFixture<UpdateHardwareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateHardwareComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateHardwareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
