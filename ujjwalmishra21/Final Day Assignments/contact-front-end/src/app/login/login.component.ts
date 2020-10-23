import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  id = undefined;
  password = undefined;
  
  response = undefined;
  constructor(private _service : UserService, private _route : Router){}

  handleLogin(data : any) {
    this.response = undefined;
    this._service.login(data).subscribe((response : any) => {
      if(response === null){
        alert('Invalid credentials');
        return;
      }

      this.response = response;
      console.log("DATA-----" + JSON.stringify(this.response));
      this._route.navigate(["/success", this.id], {
        state: { userData: response } 
      });
    })
    
  }

 
}
