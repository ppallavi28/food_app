import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FoodItemService } from '../Service/food-item.service';

@Component({
  selector: 'app-fooditem-details',
  templateUrl: './fooditem-details.component.html',
  styleUrls: ['./fooditem-details.component.css']
})
export class FooditemDetailsComponent implements OnInit {

  result:any;
  constructor(private route:Router, private fooditem:FoodItemService) { }

  ngOnInit(): void {
    this.fooditem.getData().subscribe((res)=>{
      this.result = res;
      this.result = this.result.t;
      console.log(this.result);
    })
  }

  addfooditem(){
    this.route.navigateByUrl('/add-fooditem');
  }
  back(){
    this.route.navigateByUrl('/branchmanager');
  }

  deletefooditem(fooditem:any){
    this.fooditem.deleteData(fooditem).subscribe((res)=>{
      console.log(res);
    });
  }

}
