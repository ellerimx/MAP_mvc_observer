package view;

import model.Assento;
import model.AssentoEvent;
import model.AssentoListener;
import model.Onibus;

public class Quiosque implements AssentoListener {
	//atualiza o status do assento

	public String nome;
	
	public Quiosque(String nome) {
		this.nome=nome;
	}
    @Override
    public void assentoAlterado(AssentoEvent event) {

    	Onibus onibus = (Onibus) event.getSource();

	    System.out.println(" --- " +nome + " --- ");
	    
        for (Assento a : onibus.getAssentos()) {
            System.out.println("Assento " + a.getNumeroAssento() + " -> " + a.getStatus());
        }

        System.out.println("\n");
    }
}