import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EventService {
  private baseUrl = 'http://localhost:8090/courzelo/Event/retrieve-all-events';
  private baseUrl4 = 'http://localhost:8090/courzelo/Event';
  private baseUrl2 = 'http://localhost:8090/courzelo/Event/add-event';
  private baseUrl3 = 'http://localhost:8090/courzelo/Event/modify-event';


  constructor(private http: HttpClient) { }

  getEvents(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }
  getEventsList(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  addEvent(Event: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl2}`, Event);
  }
  getEvent(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl4}/retrieve-event/${id}`);
  }

  updateEvent(id: number, value: any): Observable<Event> {
    return this.http.put<Event>(`${this.baseUrl4}/modify-event`, value);
  
  }
  deleteEvent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl4}/remove-event/${id}`, { responseType: 'text' });
  }

}
