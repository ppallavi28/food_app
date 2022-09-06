import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBranchComponent } from './add-branch/add-branch.component';
import { AddBranchmanagerComponent } from './add-branchmanager/add-branchmanager.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddFooditemComponent } from './add-fooditem/add-fooditem.component';
import { AddFoodorderComponent } from './add-foodorder/add-foodorder.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { AddOrderitemdetailComponent } from './add-orderitemdetail/add-orderitemdetail.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
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
import { AuthadminGuard } from './Guard/authadmin.guard';
import { AuthbranchmanagerGuard } from './Guard/authbranchmanager.guard';
import { AuthstaffGuard } from './Guard/authstaff.guard';
import { RestrictadminGuard } from './Guard/restrictadmin.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MenuDetailsComponent } from './menu-details/menu-details.component';
import { OrderitemdetailsComponent } from './orderitemdetails/orderitemdetails.component';
import { RegistrationComponent } from './registration/registration.component';
import { StaffDetailsComponent } from './staff-details/staff-details.component';
import { StaffComponent } from './staff/staff.component';

const routes: Routes = [
  {path:"home/registration", component:RegistrationComponent, canDeactivate:[RestrictadminGuard]},
  {path:"home", component:HomeComponent},
  {path:"home/login", component:LoginComponent},
  {path:"edit-admin", component:EditAdminComponent, canActivate:[AuthadminGuard]},
  {path:"add-branchmanager", component:AddBranchmanagerComponent, canActivate:[AuthadminGuard]},
  {path:"edit-branchmanger/:id", component:EditBranchmanagerComponent, canActivate:[AuthadminGuard]},
  {path:"admin/branchmanager-details", component:BranchmanagerDetailsComponent, canActivate:[AuthadminGuard]},
  {path:"add-staff", component:AddStaffComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"edit-staff/:id", component:EditStaffComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"branchmanager/staff-details", component:StaffDetailsComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"admin", component:AdminComponent, canActivate:[AuthadminGuard]},
  {path:"staff", component:StaffComponent, canActivate:[AuthstaffGuard]},
  {path:"branchmanager", component:BranchmanagerComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"add-branch", component:AddBranchComponent, canActivate:[AuthadminGuard]},
  {path:"edit-branch/:id", component:EditBranchComponent, canActivate:[AuthadminGuard]},
  {path:"admin/branch-details", component:BranchDetailsComponent, canActivate:[AuthadminGuard]},
  {path:"branchmanager/menu-details", component:MenuDetailsComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"add-menu", component:AddMenuComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"edit-menu/:id", component:EditMenuComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"branchmanager/fooditem-details", component:FooditemDetailsComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"add-fooditem", component:AddFooditemComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"edit-fooditem/:id", component:EditFooditemComponent, canActivate:[AuthbranchmanagerGuard]},
  {path:"staff/add-customer", component:AddCustomerComponent, canActivate:[AuthstaffGuard]},
  {path:"add-foodorder", component:AddFoodorderComponent, canActivate:[AuthstaffGuard]},
  {path:"add-orderitemdetail/:id", component:AddOrderitemdetailComponent, canActivate:[AuthstaffGuard]},
  {path:"orderitemdetails", component:OrderitemdetailsComponent, canActivate:[AuthstaffGuard]},
  {path:"displaybill", component:DisplaybillComponent, canActivate:[AuthstaffGuard]},
  {path:"admin/adminprofile", component:AdminprofileComponent, canActivate:[AuthadminGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
