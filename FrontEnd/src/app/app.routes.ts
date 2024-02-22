import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { C1Component } from './c1/c1.component';

export const routes: Routes = [
    {path:'',redirectTo:"home",pathMatch:"full"},
    {path:'home',component:HomeComponent},
    {path:'dashboard',component:C1Component}
  

];

@NgModule({
    declarations: [],
    imports: [
      CommonModule,
      RouterModule.forRoot(routes),
    ],
    exports:[RouterModule]
  })
  export class AppRoutingModule { }