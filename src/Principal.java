
import gson.ConverterParaJson;
import record.Cep;
import util.Requisicao;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Requisicao requisicao = new Requisicao();
        ConverterParaJson converte = new ConverterParaJson();
        System.out.println("***Aplicação para consulta de CEP***");
        Scanner ler = new Scanner(System.in);
        String cep = "";
        String resposta = "";

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Informe o CEP que deseja consultar ou sair para encerrar a aplicação: ");
           // cep = ler.nextLine().replace("-", "");
            cep = JOptionPane.showInputDialog("Informe o CEP que deseja consultar ou sair para encerrar a aplicação: ");
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }
            resposta = requisicao.getRequisicao(cep);
            Cep objCep = converte.converterStringParaObjetoCep(resposta);
            resposta = converte.converterObjetoCepEmJson(objCep);
            System.out.println("***Dados do arquivo Json***\n" + resposta);
           JOptionPane.showMessageDialog(null,"***Dados do arquivo Json***\n" + resposta,"Resposta",JOptionPane.INFORMATION_MESSAGE);
            converte.gravarJsonEmArquivoDeTexto(resposta);
        }
        System.out.println("Programa finalizado");
    }
}
