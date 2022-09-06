import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuService } from '../Service/menu.service';

@Component({
  selector: 'app-edit-menu',
  templateUrl: './edit-menu.component.html',
  styleUrls: ['./edit-menu.component.css']
})
export class EditMenuComponent implements OnInit {

  result:any;
  selectedmenu:any;
  menu_details:any;
  constructor(private route:ActivatedRoute, private router:Router, private menu:MenuService) { }

  ngOnInit(): void {
    this.selectedmenu = this.route.snapshot.params['id'];
  }

  updateForm = new FormGroup({
    menu_name: new FormControl("",[Validators.required]),
    bm_id: new FormControl("", [Validators.required])
  })

  get menu_name(){
    return this.updateForm.get("menu_name");
  }
  get bm_id(){
    return this.updateForm.get("bm_id");
  }

  onSubmit(){
    this.result = this.updateForm.value;
    console.log(this.result);
    console.log(this.selectedmenu);
    this.menu_details = {menu_id:this.selectedmenu, menu_name:this.result.menu_name}
    console.log(this.menu_details);
    
    this.menu.updateData(this.result.bm_id, this.menu_details, this.selectedmenu).subscribe((data)=>{
      console.log(data);
      this.router.navigateByUrl('branchmanager/menu-details');
      
    })
  }

}
