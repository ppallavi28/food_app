import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/menu")
  } 

  //Add data to the server by using http POST method
  addData(bm_id:any,menu:any){
    return this.http.post(`http://localhost:8080/api/menu/${bm_id}`, menu);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, menu:any, selectedmenu:any){
    return this.http.put(`http://localhost:8080/api/menu/${_id}?id=${selectedmenu}`,menu);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/menu/${_id}`);
  }
}
