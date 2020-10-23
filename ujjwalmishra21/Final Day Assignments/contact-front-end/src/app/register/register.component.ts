import { Component } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  id = undefined;
  name = undefined;
  password = undefined;
  dob = undefined;
  phone = undefined;
  response = undefined;

  constructor(private _service : UserService){}

  handleRegister(data : any) {
    this.response = undefined;
    console.log(JSON.stringify(data))
    this._service.register(data).subscribe((response : any) => {
      this.response = response;
      console.log("SignUp successful: " + this.response);
    })
  }


}
