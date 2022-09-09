import { Component, OnInit } from '@angular/core';
import { User } from '../../dtos/user';
import { UserService } from '../../services/user-service.service'

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.sass']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) {
    this.users = [];
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      if (data.succeeded) {
        this.users = data.value;
        console.log(data);
      }
    });
  }
}