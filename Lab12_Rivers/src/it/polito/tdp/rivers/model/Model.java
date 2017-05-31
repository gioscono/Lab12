package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private RiversDAO dao;
	private List<River> rivers;
	 
	
	public Model(){
		dao = new RiversDAO();
		rivers = new ArrayList<River>();
	}
	
	public List<River> getAllRivers(){
		rivers = dao.getAllRivers();
		return rivers;
	}
	
	public List<Flow> getMisurazioniRiver(River r){
		if(r.getMisurazioni().isEmpty()){
			r.setMisurazioni(dao.getAllFlow(r));
		}
		return r.getMisurazioni();
	}
	
	public Flow getPrimaMisurazione(River r){
		List<Flow> misurazioni = this.getMisurazioniRiver(r);
		return misurazioni.get(0);
	}
	
	public Flow getUltimaMisurazione(River r){
		List<Flow> misurazioni = this.getMisurazioniRiver(r);
		return misurazioni.get(misurazioni.size()-1);
	}
	
	public int getNumeroMisurazioni(River r){
		List<Flow> misurazioni = this.getMisurazioniRiver(r);
		return misurazioni.size();
	}
	
	public float getFlussoMedio(River r){
		List<Flow> misurazioni = this.getMisurazioniRiver(r);
		float flusso = 0;
		for(Flow f : misurazioni){
			flusso+=f.getFlow();
		}
		return flusso/misurazioni.size();
	}

}
