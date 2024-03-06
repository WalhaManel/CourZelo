import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Hardware } from './hardware';

@Injectable({
  providedIn: 'root'
})
export class HardwareService {
  private baseUrl = 'http://localhost:8090/courzelo/Hardware/retrieve-all-hardwares';
  private baseUrl4 = 'http://localhost:8090/courzelo/Hardware';
  private baseUrl2 = 'http://localhost:8090/courzelo/Hardware/add-hardware';
  private baseUrl3 = 'http://localhost:8090/courzelo/Hardware/modify-hardware';

  constructor(private http: HttpClient) { }

  getHardwares(): Observable<Hardware[]> {
    return this.http.get<Hardware[]>(this.baseUrl);
  }

  getHardwareList(): Observable<Hardware[]> {
    return this.http.get<Hardware[]>(this.baseUrl);
  }

  addHardware(hardware: Hardware): Observable<Object> {
    return this.http.post(`${this.baseUrl2}`, hardware);
  }

  getHardware(id: number): Observable<Hardware> {
    return this.http.get<Hardware>(`${this.baseUrl4}/retrieve-hardware/${id}`);
  }

  updateHardware(id: number, value: any): Observable<Hardware> {
    return this.http.put<Hardware>(`${this.baseUrl4}/modify-hardware`, value);
  }

  deleteHardware(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl4}/remove-hardware/${id}`, { responseType: 'text' });
  }
}
