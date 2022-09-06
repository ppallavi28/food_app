import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StaffService } from '../Service/staff.service';

@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.css']
})
export class AddStaffComponent implements OnInit {

  staff_details:any;
  result:any;
  constructor(private staff:StaffService, private route:Router) { }

  ngOnInit(): void {
  }

  regForm = new FormGroup({
    staff_name: new FormControl("",[Validators.required]),
    email: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("",[Validators.required, Validators.minLength(8)]),
    bm_id: new FormControl("", [Validators.required])
  })

  get staff_name(){
    return this.regForm.get("staff_name");
  }
  get email(){
    return this.regForm.get("email");
  }
  get password(){
    return this.regForm.get("password");
  }
  get bm_id(){
    return this.regForm.get("bm_id");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.staff_details = {staff_name:this.result.staff_name, email:this.result.email, password:this.result.password}
    console.log(this.staff_details);
    
    this.staff.addData(this.result.bm_id, this.staff_details).subscribe((data)=>{
      console.log(data);
      this.route.navigateByUrl('branchmanager/staff-details');
      
    }) 
  }

}
