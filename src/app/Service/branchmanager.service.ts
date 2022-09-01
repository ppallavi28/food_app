import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BranchmanagerService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/branchmanager")
  } 

  //Add data to the server by using http POST method
  addData(branch_id:any,branchmanager:any){
    return this.http.post(`http://localhost:8080/api/branchmanager/${branch_id}`, branchmanager);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, branchmanager:any, selectedbranchmanager:any){
    return this.http.put(`http://localhost:8080/api/branchmanager/${_id}?id=${selectedbranchmanager}`,branchmanager);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/branchmanager/${_id}`);
  }
}
