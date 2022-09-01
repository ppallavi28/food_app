import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StaffService } from '../Service/staff.service';

@Component({
  selector: 'app-edit-staff',
  templateUrl: './edit-staff.component.html',
  styleUrls: ['./edit-staff.component.css']
})
export class EditStaffComponent implements OnInit {

  result:any;
  selectedstaff:any;
  staff_details:any;
  constructor(private route:ActivatedRoute, private router:Router, private staff:StaffService) { }

  ngOnInit(): void {
    this.selectedstaff = this.route.snapshot.params['id'];
  }

  updateForm = new FormGroup({
    staff_name: new FormControl("",[]),
    email: new FormControl("", []),
    password: new FormControl("",[]),
    bm_id: new FormControl("", [])
  })

  get staff_name(){
    return this.updateForm.get("staff_name");
  }
  get email(){
    return this.updateForm.get("email");
  }
  get password(){
    return this.updateForm.get("password");
  }
  get bm_id(){
    return this.updateForm.get("bm_id");
  }

  onSubmit(){
    this.result = this.updateForm.value;
    console.log(this.result);
    console.log(this.selectedstaff);
    this.staff_details = {staff_id:this.selectedstaff, staff_name:this.result.staff_name, email:this.result.email, password:this.result.password}
    console.log(this.staff_details);
    
    this.staff.updateData(this.result.bm_id, this.staff_details, this.selectedstaff).subscribe((data)=>{
      console.log(data);
      this.router.navigateByUrl('branchmanager/staff-details');
      
    })
  }

}
