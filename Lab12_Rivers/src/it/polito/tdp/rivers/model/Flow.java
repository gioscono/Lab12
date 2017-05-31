package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flow {
	
	private int flowId;
	private LocalDate day;
	private float flow;
	private int riverId;
	
	public Flow(int flowId, LocalDate day, float flow, int riverId) {
		super();
		this.flowId = flowId;
		this.day = day;
		this.flow = flow;
		this.riverId = riverId;
	}

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public float getFlow() {
		return flow;
	}

	public void setFlow(float flow) {
		this.flow = flow;
	}

	public int getRiverId() {
		return riverId;
	}

	public void setRiverId(int riverId) {
		this.riverId = riverId;
	}
	
	
	

}
