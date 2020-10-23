import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl = "http://localhost:8080"
  constructor(private _http : HttpClient) { }

  register(user : any): any {
    let url = `${this.baseUrl}/register`;
    return this._http.post(url, user);
  }

  login(user : any): any {
    let url = `${this.baseUrl}/login`;
    return this._http.post(url, user);
  }

  getContacts(userId : number) : any {
  
    let url = `${this.baseUrl}/contact/${userId}`;
    return this._http.get(url);
  }

  addContact(userId : number, data : any) : any {
    console.log("//////////////////////////" + userId)
    let url = `${this.baseUrl}/contact/${userId}`;
    return this._http.post(url, data);
  }

  editDetails(userId : number, data : any ) : any {
    let url = `${this.baseUrl}/edit/${userId}`;
    return this._http.post(url, data);
  }

  getDetails(userId : number) : any {
    let url = `${this.baseUrl}/user/${userId}`;
    return this._http.get(url);
  }

  deleteContact(userId : number, contactId: number) : any {
    let url = `${this.baseUrl}/delete/${userId}/${contactId}`;
    return this._http.get(url);
  }

  editContact(userId : number, data : any) : any {
    let url = `${this.baseUrl}/contact/edit/${userId}`;
    return this._http.post(url,data);
  }
}
