import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodItemService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/foodproduct")
  } 

  //Add data to the server by using http POST method
  addData(bm_id:any,foodproduct:any){
    return this.http.post(`http://localhost:8080/api/foodproduct/${bm_id}`, foodproduct);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, foodproduct:any, selectedfoodproduct:any){
    return this.http.put(`http://localhost:8080/api/foodproduct/${_id}?id=${selectedfoodproduct}`,foodproduct);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/foodproduct/${_id}`);
  }
}
