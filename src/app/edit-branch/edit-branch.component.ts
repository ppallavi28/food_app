import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BranchService } from '../Service/branch.service';

@Component({
  selector: 'app-edit-branch',
  templateUrl: './edit-branch.component.html',
  styleUrls: ['./edit-branch.component.css']
})
export class EditBranchComponent implements OnInit {

  result:any;
  selectedBranch:any;
  branch_details:any;
  constructor(private router:Router, private branch:BranchService, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.selectedBranch = this.route.snapshot.params['id'];
  }

  updateForm = new FormGroup({
    branch_name: new FormControl("",[]),
    address: new FormControl("", []),
    admin_id: new FormControl("", [])
  })

  get branch_name(){
    return this.updateForm.get("branch_name");
  }
  get address(){
    return this.updateForm.get("address");
  }
  get admin_id(){
    return this.updateForm.get("admin_id");
  }

  onSubmit(){
    this.result = this.updateForm.value;
    console.log(this.result);
    console.log(this.selectedBranch);
    this.branch_details = {branch_id:this.selectedBranch, branch_name:this.result.branch_name, address:this.result.address}
    console.log(this.branch_details);
    
    this.branch.updateData(this.result.admin_id, this.branch_details, this.selectedBranch).subscribe((data)=>{
      console.log(data);
      this.router.navigateByUrl('admin/branch-details');
      
    })
  }
}
