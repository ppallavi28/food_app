import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../Service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthbranchmanagerGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    
      if(this.auth.isBMLoggedIn()){
        return true;
      }
      else{
        window.alert("Please Login as Branchmanager to visit this page");
        return false;
      }
  }
  constructor(private auth:AuthService){}
  
}
