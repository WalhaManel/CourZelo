import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BasketService {


  constructor(private httpClient: HttpClient) { }

  getAllProducts(): Observable<any> {
    
    return this.httpClient .get<any>('http://localhost:8080/pi/basket/showAll',{
      headers:new HttpHeaders(
        {
          // 'Authorization' : `Bearer ${localStorage.getItem('token')}`
        }
      )
    });
  }
  
}
