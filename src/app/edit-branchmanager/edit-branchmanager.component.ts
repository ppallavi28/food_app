import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BranchmanagerService } from '../Service/branchmanager.service';

@Component({
  selector: 'app-edit-branchmanager',
  templateUrl: './edit-branchmanager.component.html',
  styleUrls: ['./edit-branchmanager.component.css']
})
export class EditBranchmanagerComponent implements OnInit {

  result:any;
  selectedBranchmanager:any;
  bm_details:any;
  constructor(private router:Router, private route:ActivatedRoute, private bm:BranchmanagerService) { }

  ngOnInit(): void {
    this.selectedBranchmanager = this.route.snapshot.params['id'];
  }

  updateForm = new FormGroup({
    bm_name: new FormControl("",[Validators.required]),
    email: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("",[Validators.required, Validators.minLength(8)]),
    branch_id: new FormControl("", [Validators.required])
  })

  get bm_name(){
    return this.updateForm.get("bm_name");
  }
  get email(){
    return this.updateForm.get("email");
  }
  get password(){
    return this.updateForm.get("password");
  }
  get branch_id(){
    return this.updateForm.get("branch_id");
  }

  onSubmit(){
    this.result = this.updateForm.value;
    console.log(this.result);
    console.log(this.selectedBranchmanager);
    this.bm_details = {bm_id:this.selectedBranchmanager, bm_name:this.result.bm_name, email:this.result.email, password:this.result.password}
    console.log(this.bm_details);
    
    this.bm.updateData(this.result.branch_id, this.bm_details, this.selectedBranchmanager).subscribe((data)=>{
      console.log(data);
      this.router.navigateByUrl('admin/branchmanager-details');
      
    })
  }
 
}
