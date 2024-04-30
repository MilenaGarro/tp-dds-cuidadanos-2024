package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Transegunte {
    private List<Observer> cuidadores;
    private boolean puedeRecibirNotificaciones;
    private List<Destino> destino;
    private Integer minutosDeFalsaAlarma;
    private boolean alertas;
    Cuidador Nuevocuidador = new Cuidador();


    public Transegunte() {
        cuidadores = new ArrayList<Observer>();
        destino = new ArrayList<>();
        alertas = false;
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
        alertas = true ;

        Nuevocuidador.evaluarCuidado();
    }
    public void iniciarViaje(Destino destinoNuevo) {
        destino.add(destinoNuevo);
    }

    public void seleccionarCuidador(Observer cuidador) {
    }

    public void irHaciaUnDestino() {

    }

    public void chequearTiempo() {
    }

    public boolean estoyEnPeligro() {

    }

    public void establecerMinutosDeFalsaAlarma(Integer minutos) {
        minutosDeFalsaAlarma = minutos;
    }


class Destino {
}

class Alerta {
}

interface Observer {
    void update();
}

}