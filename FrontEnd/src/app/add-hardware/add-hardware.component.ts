import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Hardware , HardwareStatus } from "./../hardware";
import { HardwareService } from "./../hardware.service";

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-hardware',
  templateUrl: './add-hardware.component.html',
  styleUrls: ['./add-hardware.component.scss']
})
export class AddHardwareComponent implements OnInit {
  submitted = false;
  hardware: Hardware = {
    hardwareID: 0,
    hardwareName: '',
    status: HardwareStatus.ACTIVE,
    quantity: 0
  };
  hardwareStatusOptions: string[] = Object.values(HardwareStatus);

  

  constructor(private hardwareService: HardwareService,private router: Router) { }

  ngOnInit(): void { }

  newHardware(): void {
    this.submitted = false;
    this.hardware =  {
      hardwareID: 0,
      hardwareName: '',
      status: HardwareStatus.ACTIVE,
      quantity: 0
    };
  }

  save() {
    this.hardwareService.addHardware(this.hardware).subscribe(data => {
      console.log(data);
      this.hardware =  {
        hardwareID: 0,
        hardwareName: '',
        status: HardwareStatus.ACTIVE,
        quantity: 0
      };
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();  
    console.log();
  }
  BacktoAdminDashboard(){
    this.router.navigate(['AdminDashbord']);
  }
}
