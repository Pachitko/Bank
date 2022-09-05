import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../dtos/user';
import { UserRegistration } from '../dtos/user-registration';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public save(userRegistration: UserRegistration) {
    return this.http.post<UserRegistration>(this.usersUrl, userRegistration);
  }
}