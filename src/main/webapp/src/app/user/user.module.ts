import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from './users/users.component';
import { UserFormComponent } from './user-form/user-form.component';
import { RouterModule } from '@angular/router';

const routes = [
  {    path: '',    component: UsersComponent  },
  {    path: 'add',    component: UserFormComponent  },
  {    path: ':id',    component: UserFormComponent  },
];

@NgModule({
  declarations: [UsersComponent, UserFormComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class UserModule { }
