import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.route.navigateByUrl('/home');
  }

}
