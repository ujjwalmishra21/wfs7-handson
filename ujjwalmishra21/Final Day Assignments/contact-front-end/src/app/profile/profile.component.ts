import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  response = undefined;
  id = undefined;
  name = undefined;
  prevPassword = undefined;
  password = undefined;
  dob = undefined;
  phone = undefined;
  edit = false;

  constructor(private _service: UserService, private _activatedRoute: ActivatedRoute, private _router: Router){
    console.log(this._router);
    this.response = this._router.getCurrentNavigation().extras.state;
    console.log("DATA-----" + JSON.stringify(this.response));
    if(this.response !== undefined){
      this.response = this.response.userData;
      this.id = this.response.id;
      this.name = this.response.name;
      this.dob = this.response.dob;
      this.phone = this.response.phone;   
    }else{
      this._activatedRoute.parent.params.subscribe((p:Params) =>{
        this.id = p.id;
        this._service.getDetails(p.id).subscribe((response : any) => {
          this.response = response;
          this.name = this.response.name;
          this.dob = this.response.dob;
          this.phone = this.response.phone;
          console.log("ELSE case---" + JSON.stringify(this.response));
        });
      });
    }
  
  }
  ngOnInit(){
    
  }
  editOption(){
    this.edit = !this.edit;
  }

  editSubmit(){
    let data = {
      "dob": this.dob,
      "phone": this.phone
    };
    if(data == null){
      alert('Some fields must be supplied');
      return;
    }
    console.log("EDIT DETAILS----" + JSON.stringify(data));
    this._service.editDetails(this.id, data).subscribe((response : any) => {
      if( response == null ){
        alert('No response');
        return;
      }
      alert('Details updated');
    })

  }
 
}
