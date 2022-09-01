import { Component, OnInit } from '@angular/core';
import { FoodItemService } from '../Service/food-item.service';

@Component({
  selector: 'app-orderitemdetails',
  templateUrl: './orderitemdetails.component.html',
  styleUrls: ['./orderitemdetails.component.css']
})
export class OrderitemdetailsComponent implements OnInit {

  result:any;
  constructor(private fooditem:FoodItemService) { }

  ngOnInit(): void {
    this.fooditem.getData().subscribe((res)=>{
      this.result = res;
      this.result = this.result.t;
      console.log(this.result);
    })
  }

}
