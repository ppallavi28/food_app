import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuService } from '../Service/menu.service';

@Component({
  selector: 'app-menu-details',
  templateUrl: './menu-details.component.html',
  styleUrls: ['./menu-details.component.css']
})
export class MenuDetailsComponent implements OnInit {

  result:any;
  constructor(private route:Router, private menu:MenuService) { }

  ngOnInit(): void {
    this.menu.getData().subscribe((res)=>{
      this.result = res;
      this.result = this.result.t;
      console.log(this.result);
    })
  }

  addmenu(){
    this.route.navigateByUrl('/add-menu');
  }
  back(){
    this.route.navigateByUrl('/branchmanager');
  }

  deletemenu(menu_id:any){
    this.menu.deleteData(menu_id).subscribe((res)=>{
      console.log(res);
    });
  }

}
