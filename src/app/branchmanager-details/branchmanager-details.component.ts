import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BranchmanagerService } from '../Service/branchmanager.service';

@Component({
  selector: 'app-branchmanager-details',
  templateUrl: './branchmanager-details.component.html',
  styleUrls: ['./branchmanager-details.component.css']
})
export class BranchmanagerDetailsComponent implements OnInit {

  result:any;
  constructor(private route:Router, private branchmanager:BranchmanagerService) { }

  ngOnInit(): void {
    this.branchmanager.getData().subscribe((res)=>{
      this.result = res;
      this.result = this.result.t;
      console.log(this.result);
    })
  } 

  addBranchManager(){
    this.route.navigateByUrl('/add-branchmanager');
  }
  back(){
    this.route.navigateByUrl('/admin');
  }

  deletebranchmanger(bm_id:any){
    this.branchmanager.deleteData(bm_id).subscribe((res)=>{
      console.log(res);
    });
  }

}
