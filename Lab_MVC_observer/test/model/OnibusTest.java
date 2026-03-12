package model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OnibusTest {

    @Test
    void deveCriarQuantidadeCorretaDeAssentos() {
        Onibus onibus = new Onibus(4);

        assertEquals(4, onibus.getAssentos().size());

        Assento a1 = onibus.getAssentos().get(0);
        Assento a2 = onibus.getAssentos().get(1);
        Assento a3 = onibus.getAssentos().get(2);
        Assento a4 = onibus.getAssentos().get(3);

        assertEquals(1, a1.getNumeroAssento());
        assertEquals(2, a2.getNumeroAssento());
        assertEquals(3, a3.getNumeroAssento());
        assertEquals(4, a4.getNumeroAssento());

        assertEquals(StatusAssento.DISPONIVEL, a1.getStatus());
        assertEquals(StatusAssento.DISPONIVEL, a2.getStatus());
        assertEquals(StatusAssento.DISPONIVEL, a3.getStatus());
        assertEquals(StatusAssento.DISPONIVEL, a4.getStatus());
    }

    @Test
    void deveReservarAssentoDisponivel() {
        Onibus onibus = new Onibus(5);

        onibus.reservarAssento(3);

        Assento assento = onibus.getAssentos().get(2);
        assertEquals(StatusAssento.RESERVADO, assento.getStatus());
    }

    @Test
    void deveComprarAssentoDisponivel() {
        Onibus onibus = new Onibus(5);

        onibus.comprarAssento(4);

        Assento assento = onibus.getAssentos().get(3);
        assertEquals(StatusAssento.INDISPONIVEL, assento.getStatus());
    }

    @Test
    void naoDeveReservarAssentoJaReservado() {
        Onibus onibus = new Onibus(5);

        onibus.reservarAssento(2);
        onibus.reservarAssento(2);

        Assento assento = onibus.getAssentos().get(1);
        assertEquals(StatusAssento.RESERVADO, assento.getStatus());
    }

    @Test
    void naoDeveComprarAssentoJaComprado() {
        Onibus onibus = new Onibus(5);

        onibus.comprarAssento(1);
        onibus.comprarAssento(1);

        Assento assento = onibus.getAssentos().get(0);
        assertEquals(StatusAssento.INDISPONIVEL, assento.getStatus());
    }

    @Test
    void naoDeveComprarAssentoReservado() {
        Onibus onibus = new Onibus(5);

        onibus.reservarAssento(3);
        onibus.comprarAssento(3);

        Assento assento = onibus.getAssentos().get(2);
        assertEquals(StatusAssento.RESERVADO, assento.getStatus());
    }

    @Test
    void deveNotificarListenerAoReservarAssento() {
        Onibus onibus = new Onibus(5);
        ListenerFake listener = new ListenerFake();
        onibus.addAssentoListener(listener);

        onibus.reservarAssento(2);

        assertEquals(1, listener.eventosRecebidos.size());
        assertSame(onibus, listener.eventosRecebidos.get(0).getSource());
        assertEquals(2, listener.eventosRecebidos.get(0).getAssento().getNumeroAssento());
        assertEquals(StatusAssento.RESERVADO, listener.eventosRecebidos.get(0).getAssento().getStatus());
    }

    @Test
    void deveNotificarListenerAoComprarAssento() {
        Onibus onibus = new Onibus(5);
        ListenerFake listener = new ListenerFake();
        onibus.addAssentoListener(listener);

        onibus.comprarAssento(4);

        assertEquals(1, listener.eventosRecebidos.size());
        assertSame(onibus, listener.eventosRecebidos.get(0).getSource());
        assertEquals(4, listener.eventosRecebidos.get(0).getAssento().getNumeroAssento());
        assertEquals(StatusAssento.INDISPONIVEL, listener.eventosRecebidos.get(0).getAssento().getStatus());
    }

    @Test
    void naoDeveNotificarListenerQuandoOperacaoFalha() {
        Onibus onibus = new Onibus(5);
        ListenerFake listener = new ListenerFake();
        onibus.addAssentoListener(listener);

        onibus.comprarAssento(1);
        onibus.comprarAssento(1); // tentativa inválida

        assertEquals(1, listener.eventosRecebidos.size());
    }

    @Test
    void deveRemoverListener() {
        Onibus onibus = new Onibus(5);
        ListenerFake listener = new ListenerFake();
        onibus.addAssentoListener(listener);
        onibus.removeAssentoListener(listener);

        onibus.reservarAssento(2);

        assertEquals(0, listener.eventosRecebidos.size());
    }

    private static class ListenerFake implements AssentoListener {
        private final List<AssentoEvent> eventosRecebidos = new ArrayList<>();

        @Override
        public void assentoAlterado(AssentoEvent event) {
            eventosRecebidos.add(event);
        }
    }
}