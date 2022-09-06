import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../Service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthadminGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    
      if(this.auth.isAdminLoggedIn()){
        return true;
      }
      else{
        window.alert("Please Login as admin to visit this page");
        return false;
      }
  }
  constructor(private auth:AuthService){}
}
