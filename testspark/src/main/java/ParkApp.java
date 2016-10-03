/**
 * Created by winstonparris on 10/3/16.
 */

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class ParkApp {


    public static void main(String[] args) {
        get("/hello", new Route() {
            public Object handle(Request req, Response res) throws Exception {
                return "hey winston";
            }
        });
    }

}
