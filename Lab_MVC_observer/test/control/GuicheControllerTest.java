package control;
import model.Onibus;
import model.StatusAssento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuicheControllerTest {



    @Test
    void deveDelegarReservaParaOnibus() {
        Onibus onibus = new Onibus(5);
        GuicheController controller = new GuicheController(onibus);

        controller.reservar(3);

        assertEquals(StatusAssento.RESERVADO, onibus.getAssentos().get(2).getStatus());
    }

    @Test
    void deveDelegarCompraParaOnibus() {
        Onibus onibus = new Onibus(5);
        GuicheController controller = new GuicheController(onibus);

        controller.comprar(4);

        assertEquals(StatusAssento.INDISPONIVEL, onibus.getAssentos().get(3).getStatus());
    }
}