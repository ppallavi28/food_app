import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderitemdetailService } from '../Service/orderitemdetail.service';

@Component({
  selector: 'app-add-orderitemdetail',
  templateUrl: './add-orderitemdetail.component.html',
  styleUrls: ['./add-orderitemdetail.component.css']
})
export class AddOrderitemdetailComponent implements OnInit {

  orderitem_details:any;
  result:any;
  selectedorderitem:any;
  constructor(private route:ActivatedRoute, private orderitem:OrderitemdetailService, private router:Router) { }

  ngOnInit(): void {
    this.selectedorderitem = this.route.snapshot.params['id'];
  }

  regForm = new FormGroup({
    item_quantity: new FormControl("", [Validators.required])
  })

  get item_quantity(){
    return this.regForm.get("item_quantity");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.orderitem_details = {item_quantity:this.result.item_quantity}
    console.log(this.orderitem_details);
    
    this.orderitem.addData(this.selectedorderitem,localStorage.getItem('foodOrder_id'), this.orderitem_details).subscribe((data)=>{
      console.log(data);
      this.router.navigateByUrl('orderitemdetails');
      
    }) 
  }

}
