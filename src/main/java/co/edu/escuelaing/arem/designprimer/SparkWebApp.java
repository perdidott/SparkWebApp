/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;

import static spark.Spark.*;

/**
 *
 * @author 2114816
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        get("/", (req, res) -> "Hello slash");
        get("/formulario", (req, res) -> formPage());
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
                + "\n"
                + "<h1>My First Heading</h1>\n"
                + "\n"
                + "<p>My first paragraph.</p>\n"
                + "\n"
                + "</body>\n"
                + "</html>";
        return respuesta;
    }
}
