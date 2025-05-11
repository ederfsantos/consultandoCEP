package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Cep;

public class CoverterParaJson {
    /**
     * Método recebe uma String Json e devolve um objeto correspondente.
     *
     * @param conteudo
     * @return
     */
    public Cep converterJsonParaObjetoCep(String conteudo) {
        Gson gson = new Gson();
        Cep cep = gson.fromJson(conteudo, Cep.class);//instanciando um objeto apartir de um arquivo json
        return cep;

    }

    /**
     * Método recebe um objeto e devolve uma String no formato Json.
     *
     * @param cep
     * @return
     */
    public String converterObjetoCepEmJson(Cep cep) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(cep);
        return json;
    }
}
