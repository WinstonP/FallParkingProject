/**
 * Created by winstonparris on 10/3/16.
 */

import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class ParkApp {


    public static void main(String[] args) {
        get("/hello", new Route() {
            public Object handle(Request req, Response res) throws Exception {
                return "hey winston";

            }
        });
        // hello.mustache file is in resources/templates directory
        get("/template", new TemplateViewRoute() {
            public ModelAndView handle(Request rq, Response rs) throws Exception {

                Map map = new HashMap();
                map.put("name", "foobarfoo");
                return new ModelAndView(map, "hello.mustache");
            }
        }, new MustacheTemplateEngine());
    }

}
