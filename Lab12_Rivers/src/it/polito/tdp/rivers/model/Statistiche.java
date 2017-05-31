package it.polito.tdp.rivers.model;

public class Statistiche {

	private int erogazioneNonGarantita;
	private float cMed;
	
	public int getErogazioneNonGarantita() {
		return erogazioneNonGarantita;
	}
	public float getcMed() {
		return cMed;
	}
	public Statistiche(int erogazioneNonGarantita, float cMed) {
		this.erogazioneNonGarantita = erogazioneNonGarantita;
		this.cMed = cMed;
	}
	
	
	
}
