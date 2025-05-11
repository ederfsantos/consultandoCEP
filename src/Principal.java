import util.Requisicao;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Requisicao requisicao = new Requisicao();
        System.out.println("***Aplicação para consulta de CEP***");
        Scanner ler = new Scanner(System.in);
        String cep = "";
        String resposta = "";

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Informe o CEP que deseja consultar ou sair para encerrar a aplicação: ");
            cep = ler.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }
            resposta = requisicao.getRequisicao(cep);
        }
        System.out.println("Programa finalizado");
    }
}
