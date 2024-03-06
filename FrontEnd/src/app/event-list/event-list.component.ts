import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Event } from '../event'; 
import { EventService } from '../event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component .scss']
})
export class EventListComponent implements OnInit {
  events: Observable<Event[]>;

  constructor(private eventService: EventService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void {
    this.getEvents();
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
}
