import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BranchmanagerService } from '../Service/branchmanager.service';

@Component({
  selector: 'app-add-branchmanager',
  templateUrl: './add-branchmanager.component.html',
  styleUrls: ['./add-branchmanager.component.css']
})
export class AddBranchmanagerComponent implements OnInit {

  branchmanager_details:any;
  result:any;
  constructor(private bm:BranchmanagerService, private route:Router) { }

  ngOnInit(): void {
  }
 
  regForm = new FormGroup({
    branchmanager_name: new FormControl("",[Validators.required]),
    email: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("",[Validators.required, Validators.minLength(8)]),
    branch_id: new FormControl("", [Validators.required])
  })

  get branchmanager_name(){
    return this.regForm.get("branchmanager_name");
  }
  get email(){
    return this.regForm.get("email");
  }
  get password(){
    return this.regForm.get("password");
  }
  get branch_id(){
    return this.regForm.get("branch_id");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.branchmanager_details = {bm_name:this.result.branchmanager_name, email:this.result.email, password:this.result.password}
    console.log(this.branchmanager_details);
    
    this.bm.addData(this.result.branch_id, this.branchmanager_details).subscribe((data)=>{
      console.log(data);
      this.route.navigateByUrl('admin/branchmanager-details');
      
    }) 
  }

}
