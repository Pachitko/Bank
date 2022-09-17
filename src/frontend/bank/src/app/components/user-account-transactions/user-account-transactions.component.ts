import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { UserAccountTransactionOut } from 'src/app/dtos/user-account-transaction-out';
import { UserAccountTransactionService } from 'src/app/services/user-account-transaction.service';
import { UserAccountTransactionIn } from 'src/app/dtos/user-account-transaction-in';

@Component({
  selector: 'app-user-transactions',
  templateUrl: './user-account-transactions.component.html',
  styleUrls: ['./user-account-transactions.component.sass'],
})
export class UserTransactionsComponent implements OnInit {
  transactionForm = this.formBuilder.group({
    fromUserAccountId: ['', [Validators.required]],
    toUserAccountId: ['', [Validators.required]],
    amount: [0, [Validators.required, Validators.min(0)]],
  });

  transactions: UserAccountTransactionIn[];

  constructor(
    private formBuilder: FormBuilder,
    private userAccountTransactionService: UserAccountTransactionService,
    private router: Router
  ) {
    this.transactions = [];
  }

  ngOnInit() {
    this.userAccountTransactionService.findAll().subscribe((data) => {
      if (data.succeeded) {
        this.transactions = data.value;
        console.log(this.transactions);
      }

      return true;
    });
  }

  onSubmit() {
    const userAccountTransactionOut = new UserAccountTransactionOut(
      <UserAccountTransactionOut>this.transactionForm.value
    );
    this.userAccountTransactionService
      .createTransaction(userAccountTransactionOut)
      .subscribe((_) => this.navigateToTransactionsPage());
  }

  navigateToTransactionsPage() {
    this.router.navigate([environment.transactionsPage]);
  }
}
