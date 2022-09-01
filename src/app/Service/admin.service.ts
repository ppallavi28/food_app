import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/admin")
  } 

  getDatabyId(_id:any){
    return this.http.get(`http://localhost:8080/api/admin/${_id}`)
  } 

  //Add data to the server by using http POST method
  addData(admin:any){
    return this.http.post("http://localhost:8080/api/admin", admin);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, admin:any){
    return this.http.put(`http://localhost:8080/api/admin?id=${_id}`,admin);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/admin/${_id}`);
  }
}
