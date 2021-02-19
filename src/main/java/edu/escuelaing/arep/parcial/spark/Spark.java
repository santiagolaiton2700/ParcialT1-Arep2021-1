package edu.escuelaing.arep.parcial.spark;



import static spark.Spark.*;
import java.io.IOException;

import edu.escuelaing.arep.parcial.calculadora.Calculadora;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
public class Spark {
    public static void main(String[] args){
        port(getPort());
        get("/",(req, res)-> homePage(req, res));


    }
    /**      * @return the port 4567      */
    public static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static JSONObject homePage(Request req, Response res) throws IOException{

        String funcion= req.queryParams("funcion");
        double numero= Double.parseDouble(req.queryParams("numero"));
        Calculadora calculadora=new Calculadora();
        return calculadora.add(funcion,numero);

    }
}
