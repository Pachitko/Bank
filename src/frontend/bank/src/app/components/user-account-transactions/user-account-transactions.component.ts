import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { UserAccountTransactionOut } from 'src/app/dtos/user-account-transaction-out';
import { UserAccountTransactionService } from 'src/app/services/user-account-transaction.service';
import { UserAccountTransactionIn } from 'src/app/dtos/user-account-transaction-in';
import { UserService } from 'src/app/services/user-service.service';
import { UserIn } from 'src/app/dtos/userIn';
import { Observable, of, startWith, map } from 'rxjs';
import { UserAccountIn } from 'src/app/dtos/user-account-in';
import { IsUuid } from './validators';

@Component({
  selector: 'app-user-transactions',
  templateUrl: './user-account-transactions.component.html',
  styleUrls: ['./user-account-transactions.component.sass'],
})
export class UserTransactionsComponent implements OnInit {
  transactionForm = this.formBuilder.group({
    sender: ['', [Validators.required, this.validateUsername.bind(this)]],
    recipient: ['', [Validators.required, this.validateUsername.bind(this)]],
    fromUserAccountId: ['', [Validators.required, IsUuid]],
    toUserAccountId: ['', [Validators.required, IsUuid]],
    amount: [0, [Validators.required, Validators.min(0)]],
  });

  transactions: UserAccountTransactionIn[];
  users: UserIn[] = [];

  filteredSenders: Observable<UserIn[]>;
  filteredRecipients: Observable<UserIn[]>;

  filteredSenderAccounts: Observable<UserAccountIn[]>;
  filteredRecipientAccounts: Observable<UserAccountIn[]>;

  constructor(
    private formBuilder: FormBuilder,
    private userAccountTransactionService: UserAccountTransactionService,
    private router: Router,
    private userService: UserService
  ) {
    this.transactions = [];
    this.users = [];

    this.filteredSenders = of([]);
    this.filteredRecipients = of([]);

    this.filteredSenderAccounts = of([]);
    this.filteredRecipientAccounts = of([]);
  }

  ngOnInit() {
    this.userAccountTransactionService.findAll().subscribe((data) => {
      if (data.succeeded) {
        this.transactions = data.value;
      }

      return true;
    });

    this.userService.findAll().subscribe((data) => {
      this.users = data.value;
      console.log(this.users);
      return true;
    });

    const senderInput = this.transactionForm.get('sender')!;
    this.filteredSenders = senderInput.valueChanges.pipe(
      startWith(''),
      map((value) => this.filter(value || ''))
    );

    const recipientInput = this.transactionForm.get('recipient')!;
    this.filteredRecipients = recipientInput.valueChanges.pipe(
      startWith(''),
      map((value) => this.filter(value || ''))
    );

    // this.filteredSenderAccounts = this.transactionForm
    //   .get('fromUserAccountId')!
    //   .valueChanges.pipe(
    //     startWith(''),
    //     map((value) => this.filter(this.transactionForm.value || ''))
    //   );
  }

  validateUsername(control: AbstractControl) {
    if (this.users === undefined) {
      return null;
    }

    let usernameToCompare: string = control.value.toLowerCase();
    if (
      this.users.find((u) => u.username?.toLowerCase() == usernameToCompare)
    ) {
      return null;
    }
    return { invalidUser: true };
  }

  private filter(value: string): UserIn[] {
    const filterValue = value.toLowerCase();

    return this.users.filter((u) =>
      u.username!.toLowerCase().includes(filterValue)
    );
  }

  onSubmit() {
    // const userAccountTransactionOut = new UserAccountTransactionOut(
    //   <UserAccountTransactionOut>this.transactionForm.value
    // );
    // console.log(userAccountTransactionOut);
    return;
    // this.userAccountTransactionService
    //   .createTransaction(userAccountTransactionOut)
    //   .subscribe((_) => this.navigateToTransactionsPage());
  }

  navigateToTransactionsPage() {
    this.router.navigate([environment.transactionsPage]);
  }
}
