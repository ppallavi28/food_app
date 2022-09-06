import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isAdminLoggedIn(){
    if(localStorage.getItem("loggedInRole") == "Admin"){
      return true;
    }
    else{
      return false;
    }
  }

  isBMLoggedIn(){
    if(localStorage.getItem("loggedInRole") == "BranchManager"){
      return true;
    }
    else{
      return false;
    }
  }

  isStaffLoggedIn(){
    if(localStorage.getItem("loggedInRole") == "Staff"){
      return true;
    }
    else{
      return false;
    }
  }
}
