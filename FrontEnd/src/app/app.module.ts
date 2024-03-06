import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventListComponent } from './event-list/event-list.component';
// icons
import { TablerIconsModule } from 'angular-tabler-icons';
import * as TablerIcons from 'angular-tabler-icons/icons';

//Import all material modules
import { MaterialModule } from './material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

//Import Layouts
import { FullComponent } from './layouts/full/full.component';
import { BlankComponent } from './layouts/blank/blank.component';
import { FrontComponent } from './layouts/front/front.component';

// Vertical Layout
import { SidebarComponent } from './layouts/full/sidebar/sidebar.component';
import { HeaderComponent } from './layouts/full/header/header.component';
import { BrandingComponent } from './layouts/full/sidebar/branding.component';
import { AppNavItemComponent } from './layouts/full/sidebar/nav-item/nav-item.component';
import { UniversityModule } from './manage-university/university.module';

import { ClubModule } from './manage-club/club.module';
import { PreLoaderComponent } from './layouts/front/pre-loader/pre-loader.component';
import { BackToTopComponent } from './layouts/front/back-to-top/back-to-top.component';
import { NavbarComponent } from './layouts/front/navbar/navbar.component';
import { FooterComponent } from './layouts/front/footer/footer.component';
import { AddEventComponent } from './add-event/add-event.component';
import { UpdateEventComponent } from './update-event/update-event.component';
import { DetailsEventComponent } from './details-event/details-event.component';
import { EventListComponentAdmin } from './event-list/event-list.componentAdmin';
//import { HardwareListComponent } from './hardware-list/hardware-list.component';
import { HardwareListComponent } from './hardware-list/hardware-list.component';
import { HardwareListComponentAdmin } from './hardware-list/hardware-list.componentAdmin';
import { DetailsHardwareComponent } from './details-hardware/details-hardware.component';
import { AddHardwareComponent } from './add-hardware/add-hardware.component';
import { UpdateHardwareComponent } from './update-hardware/update-hardware.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    EventListComponent,
    FullComponent,
    BlankComponent,
    SidebarComponent,
    HeaderComponent,
    BrandingComponent,
    AppNavItemComponent,
    PreLoaderComponent,
    BackToTopComponent,
    NavbarComponent,
    FooterComponent,
    FrontComponent,
    AddEventComponent,
    UpdateEventComponent,
    DetailsEventComponent,
    EventListComponentAdmin,
    HardwareListComponent,
    HardwareListComponentAdmin,
    DetailsHardwareComponent,
    AddHardwareComponent,
    UpdateHardwareComponent,
    AdminDashboardComponent,
   // AddHardwareComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    TablerIconsModule.pick(TablerIcons),
    UniversityModule,
    ClubModule,
  ],
  exports: [TablerIconsModule],
  bootstrap: [AppComponent],
})
export class AppModule {}
