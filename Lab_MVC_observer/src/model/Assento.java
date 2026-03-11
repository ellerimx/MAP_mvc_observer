package model;

public class Assento {
	
	// status e numero da cadeira
	private int numeroAssento;
	private StatusAssento status;
	
	public Assento(int numeroAssento) {
		this.setNumeroAssento(numeroAssento);
		this.status = StatusAssento.DISPONIVEL;
	}

	// get e  set
	public int getNumeroAssento() {
		return numeroAssento;
	}

	public void setNumeroAssento(int numeroAssento) {
		this.numeroAssento = numeroAssento;
	}

	// get e set
	public StatusAssento getStatus() {
		return status;
	}

	public void setStatus(StatusAssento status) {
		this.status = status;
	}

}
