package utilidades;

import java.util.ArrayList;

public class Classificacao {

    public static void ordenarClassificacao(ArrayList<Time> times) {

        times.sort((t1, t2) -> {
            if (!t1.pontos.equals(t2.pontos)) {
                return t2.pontos - t1.pontos; // Maior número de pontos primeiro
            }
            if (!t1.vitorias.equals(t2.vitorias)) {
                return t2.vitorias - t1.vitorias; // Maior número de vitórias
            }
            if (!t1.golsSaldo.equals(t2.golsSaldo)) {
                return t2.golsSaldo - t1.golsSaldo; // Maior saldo de gols
            }
            return t2.golsFeitos - t1.golsFeitos; // Maior número de gols feitos
        });
    }

    public static void criarTabela() {

        System.out.println("\n-------------------------- Tabela de Classificação --------------------------\n");
        for (int i = 0; i < Time.times.size(); i++) {
            Time time = Time.times.get(i);
            System.out.printf("%dº %s | Pontos: %d | V: %d | E: %d | D: %d | SG: %d | GF: %d | GS: %d\n",
                    i + 1, time.nome, time.pontos, time.vitorias, time.empates, time.derrotas,
                    time.golsSaldo, time.golsFeitos, time.golsSofridos);
        }
        System.out.println("\n------------------------------------------------------------------------------\n");
    }
}
