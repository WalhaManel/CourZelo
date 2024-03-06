import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Event } from "./../event";
import { EventService } from "./../event.service";
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { Hardware } from '../hardware';
import { HardwareService } from '../hardware.service'; 
@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.scss']
})
export class AddEventComponent implements OnInit {
  submitted = false;
  event : Event =new Event() ;
  hardwares: Hardware[] = [];
  selectedHardwares: Hardware[] = [];
  quantities: number[] = [];
  constructor(private eventservise :EventService ,private router: Router,private hardwareService: HardwareService){ }

  ngOnInit(): void {
    this.loadHardwares();
  }

  loadHardwares() {
    this.hardwareService.getHardwares().subscribe(
      (data: Hardware[]) => {
        this.hardwares = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  newEmployee(): void {
    this.submitted = false;
    this.event = new Event();
  }

  save() {
    this.eventservise
    .addEvent(this.event).subscribe(data => {
      console.log(data)
      this.event = new Event();
      
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    for (let i = 0; i < this.hardwares.length; i++) {
      const hardware = this.hardwares[i];
      const quantity = this.quantities[i];}
    this.save();  
    console.log()  
  }
  BacktoAdminDashboard(){
    this.router.navigate(['AdminDashbord']);
  }
 
}
