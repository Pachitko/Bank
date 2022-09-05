import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './components/users-list/users-list.component'
import { SignUpComponent } from './components/sign-up/sign-up-form.component'

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'signup', component: SignUpComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }