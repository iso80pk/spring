import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user.model';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  users: User[];

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
    this.userService.getUsers()
      .subscribe(resp => {
        this.users = resp;
      });
  }
}
