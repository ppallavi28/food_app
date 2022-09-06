import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FoodorderService } from '../Service/foodorder.service';

@Component({
  selector: 'app-add-foodorder',
  templateUrl: './add-foodorder.component.html',
  styleUrls: ['./add-foodorder.component.css']
})
export class AddFoodorderComponent implements OnInit {

  foodorder_details:any;
  result:any;
  res:any;
  constructor(private foodorder:FoodorderService, private route:Router) { }

  ngOnInit(): void {
  }

  regForm = new FormGroup({
    order_name: new FormControl("",[Validators.required])
  })

  get order_name(){
    return this.regForm.get("order_name");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.foodorder_details = {order_name:this.result.order_name}
    console.log(this.foodorder_details);
    
    this.foodorder.addData(localStorage.getItem('id'), this.foodorder_details).subscribe((data)=>{
      console.log(data);
      this.res = data;
      this.res = this.res.t;
      localStorage.setItem("foodOrder_id",this.res.foodOrder_id);
      console.log(localStorage.getItem('foodOrder_id'));
      
      this.route.navigateByUrl('orderitemdetails');
      
    }) 
  }
}
