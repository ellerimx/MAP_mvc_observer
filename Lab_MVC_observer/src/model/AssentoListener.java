package model;

import java.util.EventListener;

public interface AssentoListener extends EventListener {

    void assentoAlterado(AssentoEvent event);

}