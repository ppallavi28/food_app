import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
 
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
