package domain;
import java.lang.Float;

public class Transeunte {
    String puntoDePartida;
    String puntoDeLlegada;

    boolean notificaciones;
    java.lang.Float tiempoDeDemora;

    java.lang.Float distancia;

    public void iniciarViaje() {
        Date tiempoahora = new java.util.Date();
        Destino destino = new Destino();
        float tiempoTotal;
        tiempoDeDemora = destino.calcularDistancia(puntoDePartida, puntoDeLlegada);
        tiempoTotal = tiempoDeDemora - tiempoTotal;
        distancia = destino.calcularTiempoDeDemora(puntoDePartida, puntoDeLlegada);
        this.chequearTiempoDeDemora(tiempoahora, tiempoDeDemora);
    }

    private void chequearTiempoDeDemora(Date tiempoahora, java.lang.Float tiempoDeDemora) {

        while (tiempoahora < tiempoDeDemora){
            notificaciones = false;
        }
    }
}
