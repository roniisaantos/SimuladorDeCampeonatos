package aplicacao;

import utilidades.Classificacao;
import utilidades.Rodada;
import utilidades.Tela;
import utilidades.Time;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao = 0;

        while (opcao == 0) {
            try {
                System.out.print("""
                    \n[1] Brasileirão Série A 2024
                    [2] Brasileirão Série B 2024

                    --> QUAL CAMPEONATO DESEJA SIMULAR:""" + " ");

                opcao = entrada.nextInt();

                if (opcao < 1 || opcao > 2) {
                    System.out.println("\nErro! Escolha entre 1 ou 2.");
                    opcao = 0;
                }
            } catch(InputMismatchException e) {
                System.out.println("\nDigite apenas números!");
                entrada.nextLine();
            }
        }


        Time.definirTimes(opcao);
        Rodada.definirConfrontos();

        Rodada.jogarPrimeiroTurno();
        Rodada.jogarSegundoTurno();

        Classificacao.ordenarClassificacao(Time.times);

        Classificacao.criarTabela();
    }
}