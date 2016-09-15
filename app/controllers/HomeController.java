package controllers;

import com.avaje.ebean.Ebean;
import models.CupomDesconto;
import play.Logger;
import play.mvc.*;

import views.html.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        CupomDesconto temp = new CupomDesconto();
        List<CupomDesconto>notas = temp.listar();
        return ok(index.render(notas));
    }



}
