import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-branchmanager',
  templateUrl: './branchmanager.component.html',
  styleUrls: ['./branchmanager.component.css']
})
export class BranchmanagerComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.route.navigateByUrl('/home');
  }
}
