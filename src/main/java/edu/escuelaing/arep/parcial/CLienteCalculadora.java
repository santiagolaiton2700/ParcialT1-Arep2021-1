package edu.escuelaing.arep.parcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CLienteCalculadora {

    public static void main(String[] args) throws IOException {
        CLienteCalculadora cliente = new CLienteCalculadora();
        cliente.crearCliente();
    }

    public void crearCliente() throws IOException {
        try{
        URL url = new URL("https://parcial2021.herokuapp.com/?funcion=sen&numero=15");
        HttpURLConnection conetion = (HttpURLConnection) url.openConnection();
        conetion.setRequestMethod("GET");
        conetion.setRequestProperty("Content-Type", "application/json");
        conetion.setDoOutput(true);
        conetion.setUseCaches(false);
        InputStream inconnection = conetion.getInputStream();

        BufferedReader leer = new BufferedReader(new InputStreamReader(inconnection));
        StringBuilder respuesta = new StringBuilder();
        String linea;
        while ((linea = leer.readLine()) != null) {
            respuesta.append(linea);
        }
        leer.close();
        System.out.println("El resultado fue: \n" + respuesta.toString());
    }  catch(

    IOException e)

    {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.err.println("Se presento errores al hacer la conexion");

    }
    }

}
