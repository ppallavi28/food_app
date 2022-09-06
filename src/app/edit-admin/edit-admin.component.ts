import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../Service/admin.service';

@Component({
  selector: 'app-edit-admin',
  templateUrl: './edit-admin.component.html',
  styleUrls: ['./edit-admin.component.css']
})
export class EditAdminComponent implements OnInit {

  res:any;
  constructor(private admin:AdminService, private router:Router) { }

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
    this.admin.updateData(localStorage.getItem('admin_id'), this.regForm.value).subscribe((data)=>{
      this.res = data;
      this.res = this.res.t;
      this.router.navigateByUrl('/admin/adminprofile');
    })
  }

}
