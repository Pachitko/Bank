import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../dtos/user';
import { UserRegistration } from '../dtos/user-registration';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserResponse } from '../dtos/userResponse';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = environment.usersEndpoint;
  }

  public findAll(): Observable<UserResponse<User[]>> {
    return this.http.get<UserResponse<User[]>>(this.usersUrl);;
  }

  public register(userRegistration: UserRegistration): Observable<UserRegistration> {
    return this.http.post<UserRegistration>(this.usersUrl, userRegistration);
  }
}