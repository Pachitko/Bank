import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserIn } from 'src/app/dtos/userIn';
import { UserRegistration } from 'src/app/dtos/user-registration';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserResponse } from 'src/app/dtos/userResponse';

@Injectable()
export class UserService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = environment.usersEndpoint;
  }

  public findAll(): Observable<UserResponse<UserIn[]>> {
    return this.http.get<UserResponse<UserIn[]>>(this.usersUrl);
  }

  public register(
    userRegistration: UserRegistration
  ): Observable<UserRegistration> {
    return this.http.post<UserRegistration>(this.usersUrl, userRegistration);
  }
}
