import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuService } from '../Service/menu.service';

@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css']
})
export class AddMenuComponent implements OnInit {

  menu_details:any;
  result:any;
  constructor(private menu:MenuService, private route:Router) { }

  ngOnInit(): void {
  }

  regForm = new FormGroup({
    menu_name: new FormControl("",[]),
    bm_id: new FormControl("", [])
  })

  get menu_name(){
    return this.regForm.get("menu_name");
  }
  get bm_id(){
    return this.regForm.get("bm_id");
  }

  onSubmit(){
    this.result = this.regForm.value;
    console.log(this.result);

    
    this.menu_details = {menu_name:this.result.menu_name}
    console.log(this.menu_details);
    
    this.menu.addData(this.result.bm_id, this.menu_details).subscribe((data)=>{
      console.log(data);
      this.route.navigateByUrl('branchmanager/menu-details');
      
    }) 
  }



}
