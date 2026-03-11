package model;

import java.util.EventObject;

public class AssentoEvent extends EventObject {

	private Assento assento;
	
	public AssentoEvent(Object source, Assento assento) {
		super(source);
		this.assento = assento;
		
	}
	
	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
}
