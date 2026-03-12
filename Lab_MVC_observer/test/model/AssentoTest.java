package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssentoTest {

    @Test
    void deveCriarAssentoComNumeroInformadoEStatusDisponivel() {
        Assento assento = new Assento(5);

        assertEquals(5, assento.getNumeroAssento());
        assertEquals(StatusAssento.DISPONIVEL, assento.getStatus());
    }

    @Test
    void deveAlterarNumeroDoAssento() {
        Assento assento = new Assento(1);

        assento.setNumeroAssento(8);

        assertEquals(8, assento.getNumeroAssento());
    }

    @Test
    void deveAlterarStatusDoAssento() {
        Assento assento = new Assento(2);

        assento.setStatus(StatusAssento.RESERVADO);

        assertEquals(StatusAssento.RESERVADO, assento.getStatus());
    }
}