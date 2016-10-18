/**
 * Created by winstonparris on 10/3/16.
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

import java.net.URISyntaxException;
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

        get("/send_sms", new TemplateViewRoute() {
            public ModelAndView handle(Request rq, Response rs) throws Exception {

                Map map = new HashMap();
                map.put("name", "foobarfoo");
                return new ModelAndView(map, "sendsms.mustache");
            }
        }, new MustacheTemplateEngine());

        post("/send_sms", new TemplateViewRoute() {
            public ModelAndView handle(Request rq, Response rs) throws Exception {

                String message1 = rq.queryParams("message");
                System.out.println(message1);

                Twilio.init("ACc0f8d4a3747cac8df1b073e69561fa33", "AUTHKEY GOES HERE!!!!!!!");

                Message message = Message
                        //put your number in here!
                        .creator(new PhoneNumber("+16784293807"),  // to
                                new PhoneNumber("+14704227361"),  // from
                                message1)
                        .create();

                Map map = new HashMap();
                map.put("name", "foobarfoo");
                return new ModelAndView(map, "sendsms.mustache");
            }
        }, new MustacheTemplateEngine());
    }

}
