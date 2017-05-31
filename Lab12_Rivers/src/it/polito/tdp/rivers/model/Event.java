package it.polito.tdp.rivers.model;

public class Event implements Comparable<Event> {

	public enum EventType {FLUSSO_INGRESSO};
	
	private Flow misurazione;
	private EventType type;
	
	
	public Event(Flow misurazione, EventType type) {
		this.misurazione = misurazione;
		this.type = type;
	}

	
	public Flow getMisurazione() {
		return misurazione;
	}


	public EventType getType() {
		return type;
	}


	@Override
	public int compareTo(Event altro) {
		if(this.getMisurazione().getDay().isAfter(altro.getMisurazione().getDay()))
			return 1;
		else
			return -1;
	}

}
