import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodorderService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/foodorder")
  } 

  //Add data to the server by using http POST method
  addData(cust_id:any,foodorder:any){
    return this.http.post(`http://localhost:8080/api/foodorder/${cust_id}`, foodorder);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, foodorder:any, selectedfoodorder:any){
    return this.http.put(`http://localhost:8080/api/foodorder/${_id}?id=${selectedfoodorder}`,foodorder);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/foodorder/${_id}`);
  }
}
