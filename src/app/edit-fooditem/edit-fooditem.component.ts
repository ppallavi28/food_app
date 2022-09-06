import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItemService } from '../Service/food-item.service';

@Component({
  selector: 'app-edit-fooditem',
  templateUrl: './edit-fooditem.component.html',
  styleUrls: ['./edit-fooditem.component.css']
})
export class EditFooditemComponent implements OnInit {

  result:any;
  selectedfooditem:any;
  fooditem_details:any;
  constructor(private route:ActivatedRoute, private router:Router, private fooditem:FoodItemService) { }

  ngOnInit(): void {
    this.selectedfooditem = this.route.snapshot.params['id'];
  }

  updateForm = new FormGroup({
    food_name: new FormControl("",[Validators.required]),
    price: new FormControl("",[Validators.required]),
    image_name: new FormControl("",[Validators.required]),
    description: new FormControl("",[Validators.required]),
    food_type: new FormControl("",[Validators.required]),
    quantity: new FormControl("",[Validators.required]),
    menu_id: new FormControl("", [Validators.required])
  })

  get food_name(){
    return this.updateForm.get("food_name");
  }
  get price(){
    return this.updateForm.get("price");
  }
  get image_name(){
    return this.updateForm.get("image_name");
  }
  get description(){
    return this.updateForm.get("description");
  }
  get food_type(){
    return this.updateForm.get("food_type");
  }
  get quantity(){
    return this.updateForm.get("quantity");
  }
  get menu_id(){
    return this.updateForm.get("menu_id");
  }

  onSubmit(){
    this.result = this.updateForm.value;
    console.log(this.result);
    console.log(this.selectedfooditem);
    this.fooditem_details = {food_id:this.selectedfooditem, food_name:this.result.food_name, price:this.result.price, image_name:this.result.image_name, description:this.result.description, food_type:this.result.food_type, quantity:this.result.quantity}
    console.log(this.fooditem_details);
    
    this.fooditem.updateData(this.result.menu_id, this.fooditem_details, this.selectedfooditem).subscribe((data)=>{
      console.log(data);
      this.router.navigateByUrl('branchmanager/fooditem-details');
      
    })
  }

}
