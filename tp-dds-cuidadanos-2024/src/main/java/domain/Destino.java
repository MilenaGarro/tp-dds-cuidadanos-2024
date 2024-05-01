package domain;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

public class Destino {
    private String direccionActual;
    private String puntoDeLlegada;

    private Integer numeroDeParada;

    private float tiempoDeDemora;

    private float distancia = 0;

    private String apikey = "AIzaSyD-8Jm0J6Q1J9QK5jJj6QJ6QJ6QJ6QJ6QJ"; // clave de la API de Google Maps anda a chequearlo sabes a donde

    public Destino(Integer numeroDeParada) {
        this.numeroDeParada = numeroDeParada;
    }

    public float calcularTiempoDeDemora(String direccionActual, String puntoDeLlegada, Integer tiempoXParada) {
        this.tiempoDeDemora = getTravelTime(this.apikey, direccionActual, puntoDeLlegada) + tiempoXParada;
        return this.tiempoDeDemora;
    }

    public float calcularDistancia(String direccionActual, String puntoDeLlegada) {
        try {
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey(this.apikey)
                    .build();

            DistanceMatrix result = DistanceMatrixApi.newRequest(context)
                    .origins(direccionActual)
                    .destinations(puntoDeLlegada)
                    .mode(TravelMode.WALKING)
                    .await();


            String distanceText = result.rows[0].elements[0].distance.humanReadable;
            float distanceFloat = Float.parseFloat(distanceText.replaceAll("[^\\d.]", ""));
            return distanceFloat;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static float getTravelTime(String apiKey, String origin, String destination) {
        try {
            // falta tener la clave api ???
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey(apiKey)
                    .build();

            // Realiza la solicitud a la API de Distance Matrix
            DistanceMatrix result = DistanceMatrixApi.newRequest(context)
                    .origins(origin)
                    .destinations(destination)
                    .mode(TravelMode.WALKING)
                    .await();

            long durationInSeconds = result.rows[0].elements[0].duration.inSeconds;

            // Convierte la duración de segundos a minutos como valor flotante
            float durationInMinutes = durationInSeconds / 60.0f;

            return durationInMinutes;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
