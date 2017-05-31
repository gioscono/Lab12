package it.polito.tdp.rivers.model;

import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Event.EventType;

public class Simulazione {
	
	PriorityQueue<Event> queue;
	
	private float Q;
	private float C;
	private int k;
	private float fMed;
	private int erogazioneNonGarantita;
	
	
	public Simulazione(float q, float c, int k, float fMed) {
		this.Q = q;
		this.C = c;
		this.k = k;
		this.fMed=fMed;
		this.erogazioneNonGarantita = 0;
		this.queue = new PriorityQueue<>();
	}
	
	public void addIngresso(Flow misurazione){
		queue.add(new Event(misurazione, EventType.FLUSSO_INGRESSO));
	}
	
	
	public Statistiche run(){
		
		int dim = queue.size();
		System.out.println(queue);
		float cMed = 0;
		while(!queue.isEmpty()){
			
			
			Event e = queue.poll();
			
			switch(e.getType()){
			
			case FLUSSO_INGRESSO:
				double fIn = e.getMisurazione().getFlow()*60*60*24;
				double prob = Math.random();
				double fOut = 0;
				if(prob<0.05){
					fOut=10*0.8*fMed*3600*24;
				}else{
					fOut = 0.8*fMed*3600*24;
				}

				
				//ENTRATA
				C += fIn;
				//USCITA
				if(C-fOut>=0){
					C -= fOut;
					if(C>Q)
						C=Q;
				}else{
					C=0;
					erogazioneNonGarantita++;
				}
				
				cMed += C;
				break;
			default:
				System.err.println("Tipo evento non permesso.");
				
			}
		}
		cMed = cMed/dim;
		Statistiche s = new Statistiche(erogazioneNonGarantita, cMed);
		return s;
		
	}
	
	
	

}
