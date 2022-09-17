import { Component, OnInit } from '@angular/core';
import { UserIn } from '../../dtos/userIn';
import { UserService } from '../../services/user-service.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.sass'],
})
export class UserListComponent implements OnInit {
  users: UserIn[];
  columnNames: string[] = ['username', 'email', 'accounts'];

  constructor(private userService: UserService) {
    this.users = [];
  }

  ngOnInit() {
    this.userService.findAll().subscribe((data) => {
      if (data.succeeded) {
        this.users = data.value;
        console.log(this.users);
      }

      return true;
    });
  }
}
