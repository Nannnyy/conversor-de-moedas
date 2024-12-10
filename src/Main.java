import java.io.IOException;

import modelos.Menu;
import modelos.ConsultaTaxaConversao;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        ConsultaTaxaConversao consulta = new ConsultaTaxaConversao();

        System.out.println("Seja bem-vindo(a) ao conversor de moedas!");
        int opcao = menu.imprimirMenuRetornandoOpcao();

        while (opcao != 7) {

            double quantidade = menu.imprimirMenuRetornandoValor();

            switch (opcao) {
                case 1:
                    consulta.imprimirResultadoConversao("USD", "ARS", quantidade);
                    break;

                case 2:
                    consulta.imprimirResultadoConversao("ARS", "USD", quantidade);
                    break;

                case 3:
                    consulta.imprimirResultadoConversao("USD", "BRL", quantidade);
                    break;

                case 4:
                    consulta.imprimirResultadoConversao("BRL", "USD", quantidade);
                    break;

                case 5:
                    consulta.imprimirResultadoConversao("USD", "COP", quantidade);
                    break;

                case 6:
                    consulta.imprimirResultadoConversao("COP", "USD", quantidade);
                    break;

                default:
                    System.out.println("[!] Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
            opcao = menu.imprimirMenuRetornandoOpcao();
        }
        System.out.println();
        System.out.println("[!] Programa finalizado.");

    }
}
