
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Hardware } from '../hardware';
import { HardwareService } from '../hardware.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hardware-list',
  templateUrl: './hardware-list.component.html',
  styleUrls: ['./hardware-list.component.scss']
})
export class HardwareListComponent implements OnInit {
  hardwares: Observable<Hardware[]>;

  constructor(private hardwareservice: HardwareService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void {
    this.getHardware();
  }
  
  private getHardware(): void {
    this.hardwares = this.hardwareservice.getHardwareList();
  }

  hardwareDetails(id: number){
    this.router.navigate(['details', id]);
  }

  addHardware(){
    this.router.navigate(['AddHardware']);
  }
}
