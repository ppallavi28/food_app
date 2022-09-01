import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BranchService } from '../Service/branch.service';

@Component({
  selector: 'app-branch-details',
  templateUrl: './branch-details.component.html',
  styleUrls: ['./branch-details.component.css']
})
export class BranchDetailsComponent implements OnInit {

  result:any;
  constructor(private route:Router, private branch:BranchService) { }

  ngOnInit(): void {
    this.branch.getData().subscribe((res)=>{
      this.result = res;
      this.result = this.result.t;
      console.log(this.result);
      
    })
  }

  addBranch(){
    this.route.navigateByUrl('/add-branch');
  }
  back(){
    this.route.navigateByUrl('/admin');
  }

  deleteBranch(branch_id:any){
    this.branch.deleteData(branch_id).subscribe((res)=>{
      console.log(res);
    });
  }
}
