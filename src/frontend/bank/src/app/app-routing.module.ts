import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './components/users-list/users-list.component';
import { SignUpComponent } from './components/sign-up/sign-up-form.component';
import { UserTransactionsComponent } from './components/user-account-transactions/user-account-transactions.component';

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'transactions', component: UserTransactionsComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
