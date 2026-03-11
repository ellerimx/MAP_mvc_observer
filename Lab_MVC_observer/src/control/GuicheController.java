package control;

import model.Onibus;

public class GuicheController {

	// o guiche: compra e reserva assentos, e o painel e quiosque atualiza o status do assento
    private Onibus onibus;

    public GuicheController(Onibus onibus) {
        this.onibus = onibus;
    }

    public void reservar(int assento) {
        onibus.reservarAssento(assento);
    }

    public void comprar(int assento) {
        onibus.comprarAssento(assento);
    }

}