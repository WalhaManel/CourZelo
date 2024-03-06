package tn.esprit.backend.Services;


import tn.esprit.backend.entities.Event;

import java.util.List;

public interface IEventService {
    public List<Event> retriveAllEvent();
    public Event retriveEvent(Long eventId);
    public Event addEvent(Event f);
    public void removeEvent(Long eventId);
    public Event modifyEvent(Event event);
}
