import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Event } from '../event'; 
import { EventService } from '../event.service';
import { Router } from '@angular/router';
import { HardwareService } from '../hardware.service'; 
@Component({
  selector: 'app-event-listAdmin',
  templateUrl: './admin-dashboard.html',
  styleUrls: ['./event-list.component .scss']
})
export class EventListComponentAdmin implements OnInit {
  events: Observable<Event[]>;
  
  
  constructor(private hardwareService: HardwareService,private eventService: EventService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void {
    this.getEvents();
    console.log(this.events);
  }
  
  private getEvents(): void {
    this.events = this.eventService.getEventsList();
  }

  eventDetails(id: number){
    this.router.navigate(['detailsEvent', id]);
  }
  
  AddEvent(){
    this.router.navigate(['AddEvent']);
  }
  updateEvent(id: number){
    this.router.navigate(['UpdateEvent',id]);
  }
 

  deleteEvent(id: number) {
    this.eventService.deleteEvent(id).subscribe({
      next: data => {
        console.log(data);
        this.reloadData();
      },
      error: error => console.log(error)
    });

  }
  addHardware(){
    this.router.navigate(['AddHardware']);
  }
  updateHardware(id: number){ 
    this.router.navigate(['updateHardware',id]); 
  }

  deleteHardware(id: number) {
    this.hardwareService.deleteHardware(id).subscribe({
      next: data => {
        console.log(data);
        this.reloadData();
      },
      error: error => console.log(error)
    });
}

hardwareDetails(id: number){
  this.router.navigate(['detailsHardware', id]);
}
}
