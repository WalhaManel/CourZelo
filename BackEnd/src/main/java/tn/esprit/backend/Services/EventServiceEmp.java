package tn.esprit.backend.Services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backend.Repositories.EventRepository;
import tn.esprit.backend.entities.Event;

import java.util.List;
@Service
@AllArgsConstructor
public class EventServiceEmp implements IEventService {
    EventRepository eventRepository;
    public List<Event> retrieveRepository;


    public List<Event> retriveAllEvent() {
        return eventRepository.findAll();
    }


    public Event retriveEvent(Long eventId) {
        return eventRepository.findById(eventId ).get();
    }






    public Event addEvent(Event f) {
        return eventRepository.save(f);
    }


    public void removeEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }


    public Event modifyEvent(Event event) {
        return eventRepository.save(event);
    }
}
