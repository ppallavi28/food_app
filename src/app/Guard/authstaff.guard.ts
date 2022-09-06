import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../Service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthstaffGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    
      if(this.auth.isStaffLoggedIn()){
        return true;
      }
      else{
        window.alert("Please Login as Staff to visit this page");
        return false;
      }
  }
  constructor(private auth:AuthService){}
  
}
