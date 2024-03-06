import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsHardwareComponent } from './details-hardware.component';

describe('DetailsHardwareComponent', () => {
  let component: DetailsHardwareComponent;
  let fixture: ComponentFixture<DetailsHardwareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsHardwareComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsHardwareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
