package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;

public class River {
	
	private int riverId;
	private String riverName;
	private List<Flow> misurazioni;
	
	public River(int riverId, String riverName) {
		super();
		this.riverId = riverId;
		this.riverName = riverName;
		misurazioni = new ArrayList<Flow>();
	}
	
	
	
	public List<Flow> getMisurazioni() {
		return misurazioni;
	}



	public void setMisurazioni(List<Flow> misurazioni) {
		this.misurazioni = misurazioni;
	}



	public int getRiverId() {
		return riverId;
	}
	public void setRiverId(int riverId) {
		this.riverId = riverId;
	}
	public String getRiverName() {
		return riverName;
	}
	public void setRiverName(String riverName) {
		this.riverName = riverName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + riverId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		River other = (River) obj;
		if (riverId != other.riverId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return this.riverId+" "+this.riverName;
	}
	
	

}
