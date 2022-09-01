import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StaffService } from '../Service/staff.service';

@Component({
  selector: 'app-staff-details',
  templateUrl: './staff-details.component.html',
  styleUrls: ['./staff-details.component.css']
})
export class StaffDetailsComponent implements OnInit {

  result:any;
  constructor(private route:Router, private staff:StaffService) { }

  ngOnInit(): void {
    this.staff.getData().subscribe((res)=>{
      this.result = res;
      this.result = this.result.t;
      console.log(this.result);
    })
  }

  addstaff(){
    this.route.navigateByUrl('/add-staff');
  }
  back(){
    this.route.navigateByUrl('/branchmanager');
  }

  deletestaff(staff_id:any){
    this.staff.deleteData(staff_id).subscribe((res)=>{
      console.log(res);
    });
  }

}
