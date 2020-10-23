import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent{

  response = undefined;
  id = undefined;
  name = undefined;
  phone = undefined;
  editId = undefined;
  editPhone = undefined;
  editName = undefined;
  edit = false;
  constructor(private _service: UserService, private _activatedRoute: ActivatedRoute){
   
    this._activatedRoute.parent.params.subscribe((p:Params) =>{
     
      this.id = p.id;
      this.getContacts(p.id);
    });
   
  }

  getContacts(userId : any){
    this.edit = false;
    this._service.getContacts(userId).subscribe((response: any) => {
      this.response = response.contacts;
      console.log("DATA================" + JSON.stringify(this.response.contacts))
    });
  }

  addContacts(data: any){
    this.edit = false;
    if(this.name == null || this.phone == null){
      alert("Fields cannot be empty");
      return;
    }

    this._service.addContact(this.id, data).subscribe((response: any) => {
      alert(response.name + " added to contacts")
      this._service.getContacts(this.id).subscribe((response: any) => {
        if(response == null){
          alert('Contacts cannot be fetched');
          return;
        }
        this.response = response.contacts;
        console.log("USER contacts-----------------" + JSON.stringify(this.response));  
      });
    })
  }

  deleteContact(contactId : any){
    console.log("CONTACT ID To be Deleted------" + contactId);
    this.edit = false;
    this._service.deleteContact(this.id, contactId).subscribe((response : any) => {
      if(response == null){
        alert('Error deleting contact');
        return;
      }
      alert("Contact with " + response.id + " id deleted successfully");
      this.getContacts(this.id);
    }, err => {
      console.log(err.message)
      alert("Server error");
    })
  }

  editContact(data : any){
    console.log("EDIT DATA::" + JSON.stringify(data))
    this.edit = true;
    this.editId = data.id;
    this.editName = data.name;
    this.editPhone = data.phone;
  }

  submitEditContact(data : any){
    console.log("EDIT DATA::" + JSON.stringify(data))
    let editData = {
      "id": this.editId,
      "name": data.editName,
      "phone": data.editPhone
    }

    this._service.editContact(this.id, editData).subscribe((response :  any) => {
      if(response == null){
        alert('Error editing contact');
        return;
      }
      alert("Contact with " + response.id + " id edited successfully");
      this.getContacts(this.id);
    }, err => {
      console.log(err.message)
      alert("Server error");
    })
  }

  closeEditForm(){
    this.edit = false;
  }
}
