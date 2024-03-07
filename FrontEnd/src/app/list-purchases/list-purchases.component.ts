import { Component, OnInit } from '@angular/core';
import { BasketService } from 'app/services/basket.service';
import { ListPurchasesService } from 'app/services/list-purchases.service';

@Component({
  selector: 'app-list-purchases',
  templateUrl: './list-purchases.component.html',
  styleUrls: ['./list-purchases.component.scss']
})
export class ListPurchasesComponent  implements OnInit{
  listPurchases : any;
  constructor(private purchasesService: ListPurchasesService) { }

  ngOnInit(): void {
    this.purchasesService.ShowAll().subscribe(data => {
      this.listPurchases = data;

    });

  }
}
