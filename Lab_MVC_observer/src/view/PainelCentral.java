package view;

import model.Assento;
import model.AssentoEvent;
import model.AssentoListener;
import model.Onibus;

public class PainelCentral implements AssentoListener {
	
	//atualiza o status com o quiosque

	public void assentoAlterado(AssentoEvent event) {

	    Onibus onibus = (Onibus) event.getSource();

	    System.out.println(" --- PAINEL CENTRAL: --- ");

	    for (Assento a : onibus.getAssentos()) {
	        System.out.println("Assento " + a.getNumeroAssento() + " -> " + a.getStatus());
	    }

	    System.out.println();
	}
	
}