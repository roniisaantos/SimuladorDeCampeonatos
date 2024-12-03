package utilidades;

import java.util.ArrayList;

public class Time {

    public String nome;
    public Integer pontos;
    public Integer vitorias;
    public Integer empates;
    public Integer derrotas;
    public Integer golsFeitos;
    public Integer golsSofridos;
    public Integer golsSaldo;
    public static ArrayList<Time> times = new ArrayList<>();
    public static ArrayList<Time[]> confrontosTurno1 = new ArrayList<>();
    public static ArrayList<Time[]> confrontosTurno2 = new ArrayList<>();

    static String[] timesSeriaA = {
            "Palmeiras", "Atlético-MG", "Flamengo", "Grêmio", "Botafogo",
            "Red Bull Bragantino", "Fluminense", "Athletico-PR", "Internacional", "Fortaleza",
            "São Paulo", "Cuiabá", "Corinthians", "Cruzeiro", "Vasco",
            "Bahia", "Vitória", "Juventude", "Criciúma", "Atlético-GO"
    };

    static String[] timesSerieB = {
            "Amazonas", "América-MG", "Avaí", "Botafogo-SP", "Brusque",
            "Ceará", "Chapecoense", "Coritiba", "CRB", "Goiás",
            "Guarani", "Ituano", "Mirassol", "Novorizontino", "Operário",
            "Paysandu", "Ponte Preta", "Santos", "Sport", "Vila Nova"
    };


    public Time(String nome, Integer pontos, Integer vitorias, Integer empates,
                Integer derrotas, Integer golsFeitos, Integer golsSofridos, Integer golsSaldo) {
        this.nome = nome;
        this.pontos = pontos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.golsFeitos = golsFeitos;
        this.golsSofridos = golsSofridos;
        this.golsSaldo = golsSaldo;
    }

    public static void definirTimes(int escolhaCampeonato) {

        if (escolhaCampeonato == 1) {
            for (String nome : timesSeriaA){
                times.add(new Time(nome, 0,0,0,0,0,0,0));
            }
        } else if(escolhaCampeonato == 2) {
            for (String nome : timesSerieB){
                times.add(new Time(nome, 0,0,0,0,0,0,0));
            }
        }
        else {
            System.out.println("Erro! Escolha uma opção válida!");
        }
    }
}
