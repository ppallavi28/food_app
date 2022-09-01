import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddBranchComponent } from './add-branch/add-branch.component';
import { AddBranchmanagerComponent } from './add-branchmanager/add-branchmanager.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddFooditemComponent } from './add-fooditem/add-fooditem.component';
import { AddFoodorderComponent } from './add-foodorder/add-foodorder.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { AddOrderitemdetailComponent } from './add-orderitemdetail/add-orderitemdetail.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
import { AdminDetailsComponent } from './admin-details/admin-details.component';
import { AdminComponent } from './admin/admin.component';
import { AdminprofileComponent } from './adminprofile/adminprofile.component';
import { BranchDetailsComponent } from './branch-details/branch-details.component';
import { BranchmanagerDetailsComponent } from './branchmanager-details/branchmanager-details.component';
import { BranchmanagerComponent } from './branchmanager/branchmanager.component';
import { DisplaybillComponent } from './displaybill/displaybill.component';
import { EditAdminComponent } from './edit-admin/edit-admin.component';
import { EditBranchComponent } from './edit-branch/edit-branch.component';
import { EditBranchmanagerComponent } from './edit-branchmanager/edit-branchmanager.component';
import { EditFooditemComponent } from './edit-fooditem/edit-fooditem.component';
import { EditMenuComponent } from './edit-menu/edit-menu.component';
import { EditStaffComponent } from './edit-staff/edit-staff.component';
import { FooditemDetailsComponent } from './fooditem-details/fooditem-details.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MenuDetailsComponent } from './menu-details/menu-details.component';
import { OrderitemdetailsComponent } from './orderitemdetails/orderitemdetails.component';
import { RegistrationComponent } from './registration/registration.component';
import { StaffDetailsComponent } from './staff-details/staff-details.component';
import { StaffComponent } from './staff/staff.component';

const routes: Routes = [
  {path:"home/registration", component:RegistrationComponent},
  {path:"home", component:HomeComponent},
  {path:"home/login", component:LoginComponent},
  {path:"add-admin", component:AddAdminComponent},
  {path:"edit-admin", component:EditAdminComponent},
  {path:"admin-details", component:AdminDetailsComponent},
  {path:"add-branchmanager", component:AddBranchmanagerComponent},
  {path:"edit-branchmanger/:id", component:EditBranchmanagerComponent},
  {path:"admin/branchmanager-details", component:BranchmanagerDetailsComponent},
  {path:"add-staff", component:AddStaffComponent},
  {path:"edit-staff/:id", component:EditStaffComponent},
  {path:"branchmanager/staff-details", component:StaffDetailsComponent},
  {path:"admin", component:AdminComponent},
  {path:"staff", component:StaffComponent},
  {path:"branchmanager", component:BranchmanagerComponent},
  {path:"add-branch", component:AddBranchComponent},
  {path:"edit-branch/:id", component:EditBranchComponent},
  {path:"admin/branch-details", component:BranchDetailsComponent},
  {path:"branchmanager/menu-details", component:MenuDetailsComponent},
  {path:"add-menu", component:AddMenuComponent},
  {path:"edit-menu/:id", component:EditMenuComponent},
  {path:"branchmanager/fooditem-details", component:FooditemDetailsComponent},
  {path:"add-fooditem", component:AddFooditemComponent},
  {path:"edit-fooditem/:id", component:EditFooditemComponent},
  {path:"staff/add-customer", component:AddCustomerComponent},
  {path:"add-foodorder", component:AddFoodorderComponent},
  {path:"add-orderitemdetail/:id", component:AddOrderitemdetailComponent},
  {path:"orderitemdetails", component:OrderitemdetailsComponent},
  {path:"displaybill", component:DisplaybillComponent},
  {path:"admin/adminprofile", component:AdminprofileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
