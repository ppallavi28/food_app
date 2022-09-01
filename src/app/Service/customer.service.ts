import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/customer")
  } 

  //Add data to the server by using http POST method
  addData(staff_id:any,customer:any){
    return this.http.post(`http://localhost:8080/api/customer/${staff_id}`, customer);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, customer:any, selectedcustomer:any){
    return this.http.put(`http://localhost:8080/api/customer/${_id}?id=${selectedcustomer}`,customer);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/customer/${_id}`);
  }
}
