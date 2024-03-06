import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Hardware } from '../hardware';
import { HardwareService } from '../hardware.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-hardware-list-admin',
  templateUrl: './hardware-list.componentAdmin.html', 
  styleUrls: ['./hardware-list.component.scss'] 
})
export class HardwareListComponentAdmin implements OnInit {
  hardwares: Observable<Hardware[]>; 
  constructor(private hardwareService: HardwareService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void {
    this.getHardware();
  }
  
  private getHardware(): void {
    this.hardwares = this.hardwareService.getHardwareList();
  }

  hardwareDetails(id: number){
    this.router.navigate(['detailsHardware', id]);
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
    
}