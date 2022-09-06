import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderitemdetailService } from '../Service/orderitemdetail.service';

@Component({
  selector: 'app-displaybill',
  templateUrl: './displaybill.component.html',
  styleUrls: ['./displaybill.component.css']
})
export class DisplaybillComponent implements OnInit {

  result:any;
  
  
  constructor(private bill:OrderitemdetailService, private route:Router) {
   }

  ngOnInit(): void {
    
    this.bill.getBill(localStorage.getItem('foodOrder_id')).subscribe((res)=>{
      this.result = res;
      console.log(this.result);
      
    })
  }

  back(){
    this.route.navigateByUrl('/staff');
  }

}
