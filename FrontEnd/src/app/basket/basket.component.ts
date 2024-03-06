import { Component, OnInit } from '@angular/core';
import { BasketService } from 'app/services/basket.service';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.scss']
})

export class BasketComponent implements OnInit {
  backendData: any;

  

  constructor(private BasketService: BasketService) { }

  ngOnInit(): void {
    this.BasketService.getAllProducts().subscribe(data => {
      this.backendData = data;
    });
  }
}
