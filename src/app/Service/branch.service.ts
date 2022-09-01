import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BranchService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/branch")
  } 

  //Add data to the server by using http POST method
  addData(admin_id:any,branch:any){
    return this.http.post(`http://localhost:8080/api/branch/${admin_id}`, branch);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, branch:any, selectedBranch:any){
    return this.http.put(`http://localhost:8080/api/branch/${_id}?id=${selectedBranch}`,branch);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/branch/${_id}`);
  }
}
 