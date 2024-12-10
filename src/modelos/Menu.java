package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);


    public void criarMenu(List<String> listaString){
        int maiorValor = Collections.max(listaString).length();
        maiorValor = (int) Math.pow(maiorValor, 2);
        System.out.println("-".repeat(maiorValor));

        for(String string : listaString){
            System.out.println(string);
        }
        
        System.out.println("-".repeat(maiorValor));

    }

    public int imprimirMenuRetornandoOpcao(){  

        List<String> listaString = new ArrayList<>();
        Collections.addAll(listaString, "[1] USD -> ARS", "[2] ARS -> USD", "[3] USD -> BRL", "[4] BRL -> USD", "[5] USD -> COP", "[6] COP -> USD", "[7] SAIR");
        
        criarMenu(listaString);
        System.out.println("[!] Digite a opção: ");
        int opcao = this.scanner.nextInt();

        return opcao;
    }

    public double imprimirMenuRetornandoValor(){

        System.out.println("[!] Digite o valor: ");
        double quantidade = this.scanner.nextDouble();

        System.out.println();

        return quantidade;
    }

}
