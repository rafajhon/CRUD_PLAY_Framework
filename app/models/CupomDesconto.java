package models;
import javax.persistence.*;
import javax.xml.transform.Result;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Finder;
import com.avaje.ebean.Model;

import java.util.List;

@Entity
/**
 * Created by rafael on 13/09/16.
 */
public class CupomDesconto extends Model {

    @Id @GeneratedValue
    public int id;
    public String nomeDocumento;
    public Double valor;

    public List<CupomDesconto> listar(){
        List<CupomDesconto> notas = Ebean.find(CupomDesconto.class).orderBy("id").findList();
        return notas;
    }

    public static Finder<Long, CupomDesconto> find = new Finder<>(CupomDesconto.class);
}
