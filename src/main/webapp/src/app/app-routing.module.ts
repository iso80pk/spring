import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { UserModule } from './user/user.module';
import { HalloComponent } from './hallo/hallo.component';

const routes: Routes = [
  { path: '', component: HalloComponent },
  { path: 'aboutus', component: AboutUsComponent },
  { path: 'users', loadChildren: () => UserModule  },
  {
    path: '**',
    redirectTo: '/',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
