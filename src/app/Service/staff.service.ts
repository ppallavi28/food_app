import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  constructor(private http:HttpClient) { }

  getData(){
    return this.http.get("http://localhost:8080/api/staff")
  } 

  //Add data to the server by using http POST method
  addData(bm_id:any,staff:any){
    return this.http.post(`http://localhost:8080/api/staff/${bm_id}`, staff);
  }
  
  //Updating the product details by using http put method
  updateData(_id:any, staff:any, selectedstaff:any){
    return this.http.put(`http://localhost:8080/api/staff/${_id}?id=${selectedstaff}`,staff);
  }

  //Deleteing the product using http DELETE method
  deleteData(_id:any){
    return this.http.delete(`http://localhost:8080/api/staff/${_id}`);
  }
}
