package tn.esprit.backend.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.Services.IEventService;
import tn.esprit.backend.entities.Event;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("/Event")


public class EventRestController {
    IEventService eventService;

    @GetMapping("/retrieve-all-events")
    public List<Event>getEvents(){
     List<Event> listEvents = eventService.retriveAllEvent();
        return listEvents;
    }
    @GetMapping("/retrieve-event/{event-id}")
    public Event retriveevent(@PathVariable("event-id") Long chId) {
        Event event = eventService.retriveEvent(chId);
        return event;
    }

    @PostMapping("/add-event")
    public Event addevent(@RequestBody Event c) {
        Event event = eventService.addEvent(c);
        return event;
    }
    // http://localhost:8089/tpfoyer/event/remove-event/{event-id}
    @DeleteMapping("/remove-event/{event-id}")
    public void removeevent(@PathVariable("event-id") Long chId) {
        eventService.removeEvent(chId);
    }
    // http://localhost:8089/tpfoyer/event/modify-event
    @PutMapping("/modify-event")
    public Event modifyevent(@RequestBody Event c) {
        Event event = eventService.modifyEvent(c);
        return event;
    }
}