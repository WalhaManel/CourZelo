import { Hardware } from '../hardware';
import { Component, OnInit, Input } from '@angular/core';
import { HardwareService } from '../hardware.service';
import { HardwareListComponent } from '../hardware-list/hardware-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-hardware',
  templateUrl: './details-hardware.component.html',
  styleUrls: ['./details-hardware.component.css']
})
export class DetailsHardwareComponent implements OnInit {

    id: number;
    hardware: Hardware;

    constructor(private route: ActivatedRoute,private router: Router,
                private hardwareService: HardwareService) { }

                ngOnInit() {
                  this.id = this.route.snapshot.params['id'];
              
                  this.hardwareService.getHardware(this.id)
                      .subscribe(
                          data=> {
                              console.log(data);
                              this.hardware = data;
                          },
                          error => console.log(error)
                      );
              }

              BacktoAdminDashboard(){
                this.router.navigate(['AdminDashbord']);
              }
}
