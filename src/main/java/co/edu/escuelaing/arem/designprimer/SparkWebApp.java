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
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e.on localhost)
    }
}
