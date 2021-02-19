package edu.escuelaing.arep.parcial.calculadora;

import org.json.JSONArray;
import org.json.JSONObject;

public class Calculadora {

    String funcion;
    double numero;

    public Calculadora(){


    }
    public JSONObject add(String funcion,double numero){
        double respuesta;
        this.funcion=funcion;
        this.numero=numero;
        if(funcion.equals("sen")){
            respuesta=Math.sin(numero);
        }else if(funcion.equals("cos")){
            respuesta=Math.cos(numero);
        }else if(funcion.equals("tan")){
            respuesta=Math.tan(numero);
        }else{
            respuesta=numero;
        }
        return convertir(respuesta);

    }

    public JSONObject convertir(double respuesta){
        JSONObject myJson = new JSONObject();
        myJson.put("Resultado",respuesta);
        return myJson;
    }

}
