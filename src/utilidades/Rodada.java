package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Rodada {

    static int numeroPartida = 1;

    static Random sortear = new Random();

    public static void definirConfrontos() {

        ArrayList<Time[]> possiveisConfrontosTurno1 = new ArrayList<>();
        ArrayList<Time[]> possiveisConfrontosTurno2 = new ArrayList<>();

        for (int a = 0; a < Time.times.size(); a++) {
            for (int b = a + 1; b < Time.times.size(); b++) {
                possiveisConfrontosTurno1.add(new Time[]{Time.times.get(a), Time.times.get(b)});
                possiveisConfrontosTurno2.add(new Time[]{Time.times.get(b), Time.times.get(a)});
            }
        }

        Collections.shuffle(possiveisConfrontosTurno1);
        Time.confrontosTurno1 = possiveisConfrontosTurno1;

        Collections.shuffle(possiveisConfrontosTurno2);
        Time.confrontosTurno2 = possiveisConfrontosTurno2;
    }

    public static void jogarPartida(Time timeCasa, Time timeFora) {

        int golsCasa;
        int golsFora;

        do {
            golsCasa = sortear.nextInt(0, 4) + sortear.nextInt(0, 5) - sortear.nextInt(0, 4) - sortear.nextInt(0, 5);

            golsFora = sortear.nextInt(0, 3) + sortear.nextInt(0, 4) - sortear.nextInt(0, 3) - sortear.nextInt(0, 4);
        } while (golsCasa < 0 || golsFora < 0);

        if(golsCasa > golsFora) {
            timeCasa.vitorias++;
            timeCasa.pontos += 3;
            timeFora.derrotas++;
        }
        else if (golsCasa < golsFora) {
            timeFora.vitorias++;
            timeFora.pontos += 3;
            timeCasa.derrotas++;
        }
        else {
            timeCasa.empates++;
            timeFora.empates++;
            timeCasa.pontos++;
            timeFora.pontos++;
        }

        timeCasa.golsFeitos += golsCasa;
        timeCasa.golsSofridos += golsFora;
        timeFora.golsFeitos += golsFora;
        timeFora.golsSofridos += golsCasa;
        timeCasa.golsSaldo += (golsCasa - golsFora);
        timeFora.golsSaldo += (golsFora - golsCasa);
    }

    public static void jogarPrimeiroTurno() {

        for (int i = 0; i < Time.confrontosTurno1.size(); i++) {
            jogarPartida(Time.confrontosTurno1.get(i)[0], Time.confrontosTurno1.get(i)[1]);
        }
    }

    public static void jogarSegundoTurno() {

        for (int i = 0; i < Time.confrontosTurno2.size(); i++) {
            jogarPartida(Time.confrontosTurno2.get(i)[0], Time.confrontosTurno2.get(i)[1]);
        }
    }
}
