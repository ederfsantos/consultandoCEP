package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import record.Cep;

import java.io.FileWriter;
import java.io.IOException;

public class ConverterParaJson {
    /**
     * Método recebe uma String Json e devolve um objeto correspondente.
     *
     * @param conteudo
     * @return
     */
    public Cep converterStringParaObjetoCep(String conteudo) {
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

    /**
     * Método recebe uma String Json e a grava a mesma
     * num arquivo de texto txt
     *
     * @param json
     * @throws IOException
     */
    public void gravarJsonEmArquivoDeTexto(String json) throws IOException {
        FileWriter gravar = new FileWriter("enderecoCep.txt");
        gravar.write(json);
        gravar.close();

    }
}
