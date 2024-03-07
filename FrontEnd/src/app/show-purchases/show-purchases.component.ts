import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ShowPurchasesService } from 'app/services/show-purchases.service';

@Component({
  selector: 'app-show-purchases',
  templateUrl: './show-purchases.component.html',
  styleUrls: ['./show-purchases.component.scss']
})
export class ShowPurchasesComponent implements OnInit{
  Purchases : any;
  idb : any ;
  constructor(private purchasesService: ShowPurchasesService,private activaterouter:ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.idb=this.activaterouter.snapshot.params['idb'];

    this.purchasesService.ShowPurchases(this.idb).subscribe(data => {
      this.Purchases = data;

    });

  }
}