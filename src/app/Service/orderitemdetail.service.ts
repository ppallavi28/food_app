import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderitemdetailService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/orderitemdetail")
  } 

  //Add data to the server by using http POST method
  addData(foodproductId:any,foodorderId:any,orderitemdetail:any){
    return this.http.post(`http://localhost:8080/api/orderitemdetail/foodproduct/${foodproductId}/foodorder/${foodorderId}`, orderitemdetail);
  }
  
  //Updating the product details by using http put method
  updateData(foodproductId:any,foodorderId:any,orderitemdetail:any, selectedorderitemdetail:any){
    return this.http.put(`http://localhost:8080/api/orderitemdetail/foodproduct/${foodproductId}/foodorder/${foodorderId}?id=${selectedorderitemdetail}`,orderitemdetail);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/orderitemdetail/${_id}`);
  }

  getBill(foodorderId:any){
    return this.http.get(`http://localhost:8080/api/getBill/${foodorderId}`);
  }
}
