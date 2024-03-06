import { Event } from '../event';
import { Component, OnInit, Input } from '@angular/core';
import { EventService } from '../event.service';
import { EventListComponent } from '../event-list/event-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-event',
  templateUrl: './details-event.component.html',
  styleUrls: ['./details-event.component.css']
})
export class DetailsEventComponent implements OnInit {

    id: number;
    event: Event;

    constructor(private route: ActivatedRoute,private router: Router,
                private eventService: EventService) { }

    ngOnInit() {
        this.event = new Event();

        this.id = this.route.snapshot.params['id'];

        this.eventService.getEvent(this.id)
                .subscribe(data => {
                console.log(data)
                this.event = data;
      }, error => console.log(error));
    }

    list(){
        this.router.navigate(['Event']);
    }
    BacktoAdminDashboard(){
      this.router.navigate(['AdminDashbord']);
    }
}
