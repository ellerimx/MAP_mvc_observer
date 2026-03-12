package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssentoAdapterTest {

    @Test
    void naoDeveLancarExcecaoAoReceberEvento() {

        AssentoAdapter adapter = new AssentoAdapter();
        AssentoEvent event = new AssentoEvent(new Onibus(2), new Assento(1));

        assertDoesNotThrow(() -> adapter.assentoAlterado(event));
    }
}