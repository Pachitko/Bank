import { TestBed } from '@angular/core/testing';

import { UserAccountTransactionService } from './user-account-transaction.service';

describe('UserAccountTransactionService', () => {
  let service: UserAccountTransactionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserAccountTransactionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
