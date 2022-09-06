import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FoodItemService } from '../Service/food-item.service';

@Component({
  selector: 'app-add-fooditem',
  templateUrl: './add-fooditem.component.html',
  styleUrls: ['./add-fooditem.component.css']
})
export class AddFooditemComponent implements OnInit {

  fooditem_details:any;
  result:any;
  constructor(private fooditem:FoodItemService, private route:Router) { }

  ngOnInit(): void {
  }

  regForm = new FormGroup({
    food_name: new FormControl("",[Validators.required]),
    price: new FormControl("",[Validators.required]),
    image_name: new FormControl("",[Validators.required]),
    description: new FormControl("",[Validators.required]),
    food_type: new FormControl("",[Validators.required]),
    quantity: new FormControl("",[Validators.required]),
    menu_id: new FormControl("", [Validators.required])
  })

  get food_name(){
    return this.regForm.get("food_name");
  }
  get price(){
    return this.regForm.get("price");
  }
  get image_name(){
    return this.regForm.get("image_name");
  }
  get description(){
    return this.regForm.get("description");
  }
  get food_type(){
    return this.regForm.get("food_type");
  }
  get quantity(){
    return this.regForm.get("quantity");
  }
  get menu_id(){
    return this.regForm.get("menu_id");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.fooditem_details = {food_name:this.result.food_name, price:this.result.price, image_name:this.result.image_name, description:this.result.description, food_type:this.result.food_type, quantity:this.result.quantity}
    console.log(this.fooditem_details);
    
    this.fooditem.addData(this.result.menu_id, this.fooditem_details).subscribe((data)=>{
      console.log(data);
      this.route.navigateByUrl('branchmanager/fooditem-details');
      
    }) 
  }


}
