import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddBranchmanagerComponent } from './add-branchmanager/add-branchmanager.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
import { EditAdminComponent } from './edit-admin/edit-admin.component';
import { EditBranchmanagerComponent } from './edit-branchmanager/edit-branchmanager.component';
import { EditStaffComponent } from './edit-staff/edit-staff.component';
import { AdminDetailsComponent } from './admin-details/admin-details.component';
import { BranchmanagerDetailsComponent } from './branchmanager-details/branchmanager-details.component';
import { StaffDetailsComponent } from './staff-details/staff-details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { BranchmanagerComponent } from './branchmanager/branchmanager.component';
import { StaffComponent } from './staff/staff.component';
import { AddBranchComponent } from './add-branch/add-branch.component';
import { EditBranchComponent } from './edit-branch/edit-branch.component';
import { BranchDetailsComponent } from './branch-details/branch-details.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { EditMenuComponent } from './edit-menu/edit-menu.component';
import { MenuDetailsComponent } from './menu-details/menu-details.component';
import { FooditemDetailsComponent } from './fooditem-details/fooditem-details.component';
import { EditFooditemComponent } from './edit-fooditem/edit-fooditem.component';
import { AddFooditemComponent } from './add-fooditem/add-fooditem.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddFoodorderComponent } from './add-foodorder/add-foodorder.component';
import { AddOrderitemdetailComponent } from './add-orderitemdetail/add-orderitemdetail.component';
import { OrderitemdetailsComponent } from './orderitemdetails/orderitemdetails.component';
import { DisplaybillComponent } from './displaybill/displaybill.component';
import { AdminprofileComponent } from './adminprofile/adminprofile.component';

@NgModule({
  declarations: [
    AppComponent,
    AddAdminComponent,
    AddBranchmanagerComponent,
    AddStaffComponent,
    EditAdminComponent,
    EditBranchmanagerComponent,
    EditStaffComponent,
    AdminDetailsComponent,
    BranchmanagerDetailsComponent,
    StaffDetailsComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    AdminComponent,
    BranchmanagerComponent,
    StaffComponent,
    AddBranchComponent,
    EditBranchComponent,
    BranchDetailsComponent,
    AddMenuComponent,
    EditMenuComponent,
    MenuDetailsComponent,
    FooditemDetailsComponent,
    EditFooditemComponent,
    AddFooditemComponent,
    AddCustomerComponent,
    AddFoodorderComponent,
    AddOrderitemdetailComponent,
    OrderitemdetailsComponent,
    DisplaybillComponent,
    AdminprofileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
