import { Component, OnInit } from '@angular/core';
import { Hardware ,HardwareStatus} from '../hardware';
import { ActivatedRoute, Router } from '@angular/router';
import { HardwareService } from '../hardware.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-update-hardware',
  templateUrl: './update-hardware.component.html',
  styleUrls: ['./update-hardware.component.css']
})
export class UpdateHardwareComponent implements OnInit {
  submitted = false;
  id: number;
  hardware: Hardware;
  hardwares: Observable<Hardware[]>;
  hardwareStatusOptions: string[] = Object.values(HardwareStatus);

  constructor(private route: ActivatedRoute, private router: Router, private hardwareService: HardwareService) { }

  ngOnInit(): void {
    this.hardware = {
      hardwareID: 0,
      hardwareName: '',
      status: HardwareStatus.ACTIVE,
      quantity: 0
    };
    this.id = +this.route.snapshot.params['id']; 

    this.hardwareService.getHardware(this.id)
      .subscribe({
        next: (data: Hardware) => {
          console.log(data);
          this.hardware = data;
        },
        error: error => console.log(error)
      });
  }

  updateHardware(): void {
    this.hardwareService.updateHardware(this.id, this.hardware)
      .subscribe({
        next: (data: any) => {
          console.log(data);
          this.hardware = data as Hardware; 
        }
      }); 
  }

  onSubmit(): void {
    this.updateHardware();
  }

  BacktoAdminDashboard(){
    this.router.navigate(['AdminDashbord']);
  }
}
