
import { Hardware } from './hardware';
export class Event {
    eventID: number; 
    eventName: string;
    eventDescription: string;
    eventDate: Date; 
    price: number; 
    availablePlaces: number; 
    eventPlaces: number;
    latitude: string; 
    longitude: string; 
    hardwares: Hardware[];
  }
  