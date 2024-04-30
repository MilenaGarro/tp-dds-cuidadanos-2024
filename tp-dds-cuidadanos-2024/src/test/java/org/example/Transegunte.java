package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Transegunte {
    private List<Observer> cuidadores;
    private boolean puedeRecibirNotificaciones;
    private List<Destino> destino;
    private Integer minutosDeFalsaAlarma;
    private List<Alerta> alertas;
    Cuidador Nuevocuidador = new Cuidador();


    public Transegunte() {
        cuidadores = new ArrayList<Observer>();
        destino = new ArrayList<>();
        alertas = new ArrayList<>();
        puedeRecibirNotificaciones = true;
        minutosDeFalsaAlarma = 0;
    }

    public void agregar(Observer cuidador){
    cuidadores.add(cuidador);
    }
    public void eliminar(Observer cuidador){
        cuidadores.remove(cuidador);
    }

    public void finalizarViaje() {
        destino.clear();
        alertas.clear();

        Nuevocuidador.evaluarCuidado();
    }
    public void iniciarViaje(Destino destinoNuevo) {
        destino.add(destinoNuevo);
    }

    public void seleccionarCuidador() {
    }

    public void irHaciaUnDestino() {
    }

    public void chequearTiempo() {
    }

    public boolean estoyEnPeligro() {
        return false;
    }

    public void establecerMinutosDeFalsaAlarma(Integer minutos) {
        minutosDeFalsaAlarma = minutos;
    }


class Destino {
}

class Alerta {
}

interface Observer {
    void update(); // This would be called to notify the observer of changes
}

}