import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../Service/admin.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  res:any;
  constructor(private router:Router, private admin:AdminService) { }

  ngOnInit(): void {
  }

  regForm = new FormGroup({
    admin_name: new FormControl("",[Validators.required]),
    email: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("", [Validators.required, Validators.minLength(8)])
  })

  get admin_name(){
    return this.regForm.get("admin_name");
  }
  get email(){
    return this.regForm.get("email");
  }
  get password(){
    return this.regForm.get("password");
  }

  onSubmit(){
    this.admin.addData(this.regForm.value).subscribe((data)=>{
      this.res = data;
      this.res = this.res.t;
      console.log("Successful registration of admin");
      localStorage.setItem("loggedInRole", "Admin");
      localStorage.setItem("admin_id",this.res.admin_id);
      this.router.navigateByUrl('/admin');
    })
  }
}
