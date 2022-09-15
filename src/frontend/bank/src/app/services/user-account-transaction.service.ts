import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserAccountTransactionOut } from '../dtos/user-account-transaction-out';
import { UserAccountTransactionIn } from '../dtos/user-account-transaction-in';
import { UserResponse } from '../dtos/userResponse';

@Injectable()
export class UserAccountTransactionService {
  constructor(private http: HttpClient) {}

  public findAll(): Observable<UserResponse<UserAccountTransactionIn[]>> {
    return this.http.get<UserResponse<UserAccountTransactionIn[]>>(
      environment.transactionsEndpoint
    );
  }

  public createTransaction(transaction: UserAccountTransactionOut) {
    return this.http.post<UserResponse<boolean>>(
      environment.transactionsEndpoint,
      transaction
    );
  }
}
