package aplicacao;

import utilidades.Classificacao;
import utilidades.Rodada;
import utilidades.Tela;
import utilidades.Time;

public class ProgramaComTela {

    public static void main(String[] args) {
        Tela tela = new Tela();

        tela.exibirEscolhaCampeonato(() -> {

            int opcao = tela.getDefinirCampeonato();

            Time.definirTimes(opcao);
            Rodada.definirConfrontos();
            Rodada.jogarPrimeiroTurno();
            Rodada.jogarSegundoTurno();
            Classificacao.ordenarClassificacao(Time.times);

            // Exibe a classificação na interface gráfica
            tela.exibirClassificacao(Time.times);
        });
    }
}
