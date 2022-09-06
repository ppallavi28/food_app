import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from '../Service/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customer_details:any;
  result:any;
  res:any;
  constructor(private customer:CustomerService, private route:Router) { }

  ngOnInit(): void {
  }

  regForm = new FormGroup({
    name: new FormControl("",[Validators.required]),
    email: new FormControl("", [Validators.required, Validators.email]),
    phone_number: new FormControl("",[Validators.required, Validators.maxLength(10), Validators.minLength(10)]),
    staff_id: new FormControl("", [Validators.required])
  })

  get name(){
    return this.regForm.get("name");
  }
  get email(){
    return this.regForm.get("email");
  }
  get phone_number(){
    return this.regForm.get("phone_number");
  }
  get staff_id(){
    return this.regForm.get("staff_id");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.customer_details = {name:this.result.name, email:this.result.email, phoneNumber:this.result.phone_number}
    console.log(this.customer_details);
    
    this.customer.addData(this.result.staff_id, this.customer_details).subscribe((data)=>{
      console.log(data);
      this.res = data;
      this.res = this.res.t;
      localStorage.setItem("id",this.res.id);
      this.route.navigateByUrl('add-foodorder');
      
    }) 
  }


}
