import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactsComponent } from './contacts/contacts.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { SuccessComponent } from './success/success.component';

const routes: Routes = [
  { path: "", component: LoginComponent},
  { path: "register", component: RegisterComponent},
  { path: "success/:id", component: SuccessComponent, children:[
    { path : "", component: ProfileComponent},
    { path : "contact", component: ContactsComponent},
    { path : "profile", component: ProfileComponent}
  ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
