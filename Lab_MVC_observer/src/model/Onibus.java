package model;

import java.util.ArrayList;
import java.util.List;

public class Onibus {

    private List<Assento> assentos;
    private List<AssentoListener> listeners;

    public Onibus(int quantidade) {

        assentos = new ArrayList<>();
        listeners = new ArrayList<>();

        for(int i=1;i<=quantidade;i++) {
            assentos.add(new Assento(i));
        }
    }
    
    //lista de todos os assentos
    public List<Assento> getAssentos() {
        return assentos;
    }

    public void addAssentoListener(AssentoListener l) {
        listeners.add(l);
    }

    public void removeAssentoListener(AssentoListener l) {
        listeners.remove(l);
    }

    private void disparaAssentoAlterado(Assento assento) {

        AssentoEvent event = new AssentoEvent(this, assento);

        for(AssentoListener l : listeners) {
            l.assentoAlterado(event);
        }
    }

    public void reservarAssento(int numero) {

        Assento a = assentos.get(numero-1);

        if(a.getStatus() != StatusAssento.DISPONIVEL) {
            System.out.println("Assento INDISPONIVEL!! Escolha outro assento.");
            return;
        }

        a.setStatus(StatusAssento.RESERVADO);

        disparaAssentoAlterado(a);
    }
    
    public void comprarAssento(int numero) {

        Assento a = assentos.get(numero-1);

        if(a.getStatus() != StatusAssento.DISPONIVEL) {
            System.out.println("Assento INDISPONIVEL!! Escolha outro assento."); // assento indisponivel no onibus
            return;
        }

        a.setStatus(StatusAssento.INDISPONIVEL);
        disparaAssentoAlterado(a);
    }

}