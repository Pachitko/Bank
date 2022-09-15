import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user-service.service';
import { FormBuilder,Validators } from '@angular/forms';
import { UserRegistration } from 'src/app/dtos/user-registration';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-user-form',
  templateUrl: './sign-up-form.component.html',
  styleUrls: ['./sign-up-form.component.sass']
})

export class SignUpComponent {
  userForm = this.formBuilder.group({
    username: ['', Validators.required],
    email: ['', Validators.required],
    password: ['', Validators.required]
  });

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private formBuilder: FormBuilder) {
  }

  onSubmit() {
    const userRegistration = new UserRegistration(<UserRegistration>this.userForm.value);
    this.userService.register(userRegistration).subscribe(_ => this.navigateToUserList());
  }

  navigateToUserList() {
    this.router.navigate([environment.usersPage]);
  }
}