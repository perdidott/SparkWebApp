/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;

import spark.Request;
import spark.Response;
import static spark.Spark.*;
import edu.escuelaing.arem.ASE.app.collections.LinkedList;
import edu.escuelaing.arem.math.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 2114816
 */
public class SparkWebApp {
    
    static Stat mean = new Stat();
    static StandardDeviation standard = new StandardDeviation();

    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> formPage());
        get("/action_page", (req, res) -> actionPage(req, res));
        
        
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e.on localhost)
    }

    public static String formPage() {
        String respuesta = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<body>\n"
                + "<h2>Calcula promedio y desviacion estandar de una lista de datos</h2>\n"
                + "\n"
                + "<form action=\"/action_page\">\n"
                + "  Lista de datos:<br>\n"
                + "  <input type=\"text\"name=\"datos\" value=\"0.0\">\n"
                + "  <br>\n"
                + "<br><br>\n"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form> \n"
                + "\n"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/action_page\".</p>"
                + "</body>\n"
                + "</html>";
        return respuesta;
    }

    private static String actionPage(Request req, Response res) {
        String datos = req.queryParams("datos");
        
        Scanner scanner = new Scanner(datos);
        
        ArrayList<Double> lista = new ArrayList<Double>();
        
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                lista.add(scanner.nextDouble());
            } else {
                scanner.next();
            }
        }
        
        LinkedList<Double> l = new LinkedList<Double>(lista);
        
        double average = mean.mean(l);
        double standardD = standard.standardD(l);
        String respuesta =  "<h2>Mean: </h2>" 
                            + average 
                            + "\n </br>"
                            + "<h2>Standard deviation: </h2>" 
                            + standardD;
        return respuesta;
    }
    
}
