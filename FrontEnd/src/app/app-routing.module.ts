import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlankComponent } from './layouts/blank/blank.component';
import { FullComponent } from './layouts/full/full.component';
import { FrontComponent } from './layouts/front/front.component';
import { DetailsEventComponent } from './details-event/details-event.component';
import { AppSideLoginComponent } from './pages/authentication/login/login.component';
import { AppSideRegisterComponent } from './pages/authentication/register/register.component';
import { LandingpageComponent } from './pages/landingpage/landingpage.component';
import { NotfoundComponent } from './pages/notfound/notfound.component';
import { AddEventComponent } from './add-event/add-event.component';
import { EventListComponent } from './event-list/event-list.component';
import { EventListComponentAdmin } from './event-list/event-list.componentAdmin';
import { UpdateEventComponent } from './update-event/update-event.component';
import { DetailsHardwareComponent } from './details-hardware/details-hardware.component';
import { HardwareListComponent } from './hardware-list/hardware-list.component';
import { AddHardwareComponent } from './add-hardware/add-hardware.component';
import { UpdateHardwareComponent } from './update-hardware/update-hardware.component';

import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';


const routes: Routes = [
  {
    path: 'dashboard',
    component: FullComponent,
    children: [
      {
        path: '',
        loadChildren: () =>
          import('./pages/pages.module').then((m) => m.PagesModule),
      },

    ],
  },

  //front-----------------------
  {
    path: '',
    component: FrontComponent,
    children: [
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full',
      },
      
      {
        path: 'home',
        component: LandingpageComponent,
      },

      {
        path: 'course',
        loadChildren: () =>
          import('./manage-club/club.module').then((m) => m.ClubModule),
      },
      {
        path: 'AddEvent', component:AddEventComponent
       
      },
      {
        path: 'AdminDashbord', component:AdminDashboardComponent
       
      },
      {
        path: 'AddHardware', component:AddHardwareComponent
       
      },

      { path: 'detailsEvent/:id', component: DetailsEventComponent },


      { path: 'detailsHardware/:id', component: DetailsHardwareComponent },


      { path: 'UpdateEvent/:id', component: UpdateEventComponent },


      { path: 'updateHardware/:id', component: UpdateHardwareComponent },

      {
        path: 'Event', component:EventListComponent
       
      },
      {
        path: 'Hardware', component:HardwareListComponent
       
      },
      {
        path: 'AdminEvent', component:EventListComponentAdmin
       
      },
      {
        path: '',
        loadChildren: () =>
          import('./pages/authentication/authentication.module').then(
            (m) => m.AuthenticationModule
          ),
      },
    ],
  },
  {
    path: '**',
    component: FrontComponent,
    children: [
      {
        path: '',
        component: NotfoundComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
