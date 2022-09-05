import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user-service.service';
import { UserRegistration } from 'src/app/dtos/user-registration';

@Component({
  selector: 'app-user-form',
  templateUrl: './sign-up-form.component.html',
  styleUrls: ['./sign-up-form.component.css']
})
export class SignUpComponent {

  user: UserRegistration;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new UserRegistration();
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.navigateToUserList());
  }

  navigateToUserList() {
    this.router.navigate(['/users']);
  }
}