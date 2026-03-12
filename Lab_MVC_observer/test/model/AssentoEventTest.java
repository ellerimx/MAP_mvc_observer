package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AssentoEventTest {


    @Test
    void deveCriarEventoComSourceEAssentoInformados() {
        Onibus onibus = new Onibus(3);
        Assento assento = new Assento(2);

        AssentoEvent event = new AssentoEvent(onibus, assento);

        assertSame(onibus, event.getSource());
        assertSame(assento, event.getAssento());
    }

    @Test
    void deveAlterarAssentoDoEvento() {
        Onibus onibus = new Onibus(3);
        Assento assento1 = new Assento(1);
        Assento assento2 = new Assento(2);

        AssentoEvent event = new AssentoEvent(onibus, assento1);
        event.setAssento(assento2);

        assertSame(assento2, event.getAssento());
    }
}