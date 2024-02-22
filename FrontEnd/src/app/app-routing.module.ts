import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { C1Component } from './c1/c1.component';
import { C2Component } from './c2/c2.component';
import { C3Component } from './c3/c3.component';
import { CourseComponent } from './course/course.component';
import { HomeComponent } from './home/home.component';
import { JoinnowComponent } from './joinnow/joinnow.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'course', component: CourseComponent },
  { path: 'joinnow', component: JoinnowComponent },
  { path: 'about', component: AboutComponent },
  { path: 'c1', component: C1Component },
  { path: 'c2', component: C2Component },
  { path: 'c3', component: C3Component },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
