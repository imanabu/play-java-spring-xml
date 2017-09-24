package controllers;

import modules.MyBeanA;
import modules.MyBeanB;
import play.mvc.Controller;
import play.mvc.Result;
import services.MyService;
import views.html.index;

import javax.inject.Inject;

public class Application extends Controller {


    @Inject
    MyService myService;

    @Inject
    MyBeanA myBeanA;

    public Result index() {
        String message = myService.doService();
        return ok(index.render("My Service says: " + message + myBeanA.getMessage()));
    }

}
