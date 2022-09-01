import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../Service/admin.service';

@Component({
  selector: 'app-adminprofile',
  templateUrl: './adminprofile.component.html',
  styleUrls: ['./adminprofile.component.css']
})
export class AdminprofileComponent implements OnInit {

  result:any;
  constructor(private admin:AdminService, private router:Router) { }

  ngOnInit(): void {
    this.admin.getDatabyId(localStorage.getItem('admin_id')).subscribe((res)=>{
      this.result = res;
      this.result = this.result.t;
      console.log(this.result);
      
    })
  }

  back(){
    this.router.navigateByUrl('/admin')
  }

}
