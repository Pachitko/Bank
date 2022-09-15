import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './components/users-list/users-list.component';
import { UserService } from './services/user-service.service';
import { SignUpComponent } from './components/sign-up/sign-up-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';
import { BodyComponent } from './components/body/body.component';
import { UserTransactionsComponent } from './components/user-account-transactions/user-account-transactions.component';
import { UserAccountTransactionService } from './services/user-account-transaction.service';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    SignUpComponent,
    HeaderComponent,
    BodyComponent,
    UserTransactionsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [UserService, UserAccountTransactionService],
  bootstrap: [AppComponent],
})
export class AppModule {}
