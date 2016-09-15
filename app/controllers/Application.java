package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Update;
import models.CupomDesconto;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.*;
import play.mvc.*;
import views.html.*;

import javax.inject.Inject;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.ENC_CASE_FOLD_DEFAULT;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * Created by rafael on 13/09/16.
 */
public class Application extends Controller {
    @Inject
    FormFactory formFactory;

    public Result submit() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        CupomDesconto teste = new CupomDesconto();
        teste.nomeDocumento = requestData.get("nomeDocumento");
        teste.valor = Double.parseDouble(requestData.get("valor"));
        teste.save();
        return redirect("/");
    }

    public Result editar() {
        CupomDesconto temp = new CupomDesconto();
        List<CupomDesconto> notas = temp.listar();
        return ok(editar.render(notas));
    }

    public Result atualizar() {
        Form<CupomDesconto> requestData = formFactory.form(CupomDesconto.class).bindFromRequest("nomeDocumento",
                                                                                                "valor",
                                                                                                "id");
        Logger.info("form" + requestData.toString());
        CupomDesconto teste = requestData.get();
        CupomDesconto temp;
        temp = CupomDesconto.find.byId(new Long(teste.id));
        temp.nomeDocumento = teste.nomeDocumento;
        temp.valor = teste.valor;
        temp.update();
        return redirect("/editar");
    }

    public Result excluir(){
        Form<CupomDesconto> requestData = formFactory.form(CupomDesconto.class).bindFromRequest("nomeDocumento",
                "valor", "id");
        CupomDesconto teste = requestData.get();
        CupomDesconto temp;
        temp = CupomDesconto.find.byId(new Long(teste.id));
        temp.delete();
        return redirect("/editar");
    }
    public Result buscar(){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        CupomDesconto teste = new CupomDesconto();
        teste.nomeDocumento = requestData.get("nomeDocumento");
        Logger.info(teste.nomeDocumento);
        List<CupomDesconto>temp;
        temp = Ebean.find(CupomDesconto.class).where().eq("nomeDocumento", teste.nomeDocumento).findList();
        return ok(buscar.render(temp));
    }
}
