import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BranchService } from '../Service/branch.service';

@Component({
  selector: 'app-add-branch',
  templateUrl: './add-branch.component.html',
  styleUrls: ['./add-branch.component.css']
})
export class AddBranchComponent implements OnInit {

  constructor(private branch:BranchService, private route:Router) { }

  branch_details:any;
  result:any;
  ngOnInit(): void {
  }

  regForm = new FormGroup({
    branch_name: new FormControl("",[]),
    address: new FormControl("", []),
    admin_id: new FormControl("", [])
  })

  get branch_name(){
    return this.regForm.get("branch_name");
  }
  get address(){
    return this.regForm.get("address");
  }
  get admin_id(){
    return this.regForm.get("admin_id");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.branch_details = {branch_name:this.result.branch_name, address:this.result.address}
    console.log(this.branch_details);
    
    this.branch.addData(this.result.admin_id, this.branch_details).subscribe((data)=>{
      console.log(data);
      this.route.navigateByUrl('admin/branch-details');
      
    }) 
  }

}
