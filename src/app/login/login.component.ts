import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../Service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  result:any;
  loginFormValue:any;
  res:any;
  role:String = "";
  status:boolean = false;

  constructor(private loginDetail:LoginService, private route:Router) { }

  ngOnInit(): void {
  }

  loginForm = new FormGroup({
    email: new FormControl("", []),
    password: new FormControl("", [])
  })

  get email(){
    return this.loginForm.get("email");
  }

  get password(){
    return this.loginForm.get("password");
  }

  login(){
    this.loginDetail.checkLogin(this.loginForm.value).subscribe((res)=>{
      this.result = res;
      console.log(this.result.role);
      console.log(this.result.success);
      
      if(this.result.role === "Admin" && this.result.success === true){
        localStorage.setItem("loggedInRole", this.result.role);
        this.route.navigateByUrl('/admin');
      }
      else if(this.result.role === "BranchManager" && this.result.success === true){
        localStorage.setItem("loggedInRole", this.result.role);
        this.route.navigateByUrl('/branchmanager');
      }
      else if(this.result.role === "Staff" && this.result.success === true){
        localStorage.setItem("loggedInRole", this.result.role);
        this.route.navigateByUrl('/staff');
      }
      else{
        window.alert("Please enter valid email and password");
      }
      
    })
  }
}
