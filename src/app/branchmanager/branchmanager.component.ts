import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-branchmanager',
  templateUrl: './branchmanager.component.html',
  styleUrls: ['./branchmanager.component.css']
})
export class BranchmanagerComponent implements OnInit {
 
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
