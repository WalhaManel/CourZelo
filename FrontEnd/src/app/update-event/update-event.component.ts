import { Component, OnInit } from '@angular/core';
import { Event } from '../event';
import { ActivatedRoute, Router } from '@angular/router';
import { EventService } from '../event.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-update-event',
  templateUrl: './update-event.component.html',
  styleUrls: ['./update-event.component.css']
})
export class UpdateEventComponent implements OnInit {
  submitted = false;
  id: number;
  event: Event;
  events: Observable<Event[]>;

  constructor(private route: ActivatedRoute, private router: Router, private eventService: EventService) { }

  ngOnInit(): void {
    this.event = new Event();
    this.id = +this.route.snapshot.params['id']; 

    this.eventService.getEvent(this.id)
      .subscribe({
        next: (data: Event) => {
          console.log(data);
          this.event = data;
        },
        error: error => console.log(error)
      });
  }

  updateEvent(): void {
    this.eventService.updateEvent(this.id, this.event)
      .subscribe({
        next: (data: any) => {
          console.log(data);
          this.event = data as Event; 
        }
      }); 
  }

  onSubmit(): void {
    this.updateEvent();
  }

  BacktoAdminDashboard(){
    this.router.navigate(['AdminDashbord']);
  }
}
