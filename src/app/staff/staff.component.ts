import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  loginImg:String = "";
  constructor(private route:Router) {
    this.loginImg = '/assets/images/loginImage.png';
   }

  ngOnInit(): void {
  }

  logout(){
    localStorage.setItem("loggedInRole", "logout");
    this.route.navigateByUrl('/home');
  }

}
