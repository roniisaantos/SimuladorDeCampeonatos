package utilidades;

import java.util.ArrayList;
import java.util.Random;

public class Time {

    public String nome;
    public Integer pontos;
    public Integer vitorias;
    public Integer empates;
    public Integer derrotas;
    public Integer golsFeitos;
    public Integer golsSofridos;
    public Integer golsSaldo;
    public Integer chanceGols;
    public ArrayList<Time> times = new ArrayList<>();
    public ArrayList<Time[]> confrontosHistorico = new ArrayList<>();
    public Time[] confrontoAtual = new Time[2];



    Random sortear = new Random();

    String[] timesSeriaA = {
            "Palmeiras", "Atlético-MG", "Flamengo", "Grêmio", "Botafogo",
            "Red Bull Bragantino", "Fluminense", "Athletico-PR", "Internacional", "Fortaleza",
            "São Paulo", "Cuiabá", "Corinthians", "Cruzeiro", "Vasco",
            "Bahia", "Vitória", "Juventude", "Criciúma", "Atlético-GO"
    };

    String[] timesSerieB = {
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

    public void CriarTabela(int escolhaCampeonato) {

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


    @Override
    public String toString() {
        return "Time: " + nome +
                ", Pontos: " + pontos +
                ", Vitórias: " + vitorias +
                ", Empates: " + empates +
                ", Derrotas: " + derrotas +
                ", Gols Feitos: " + golsFeitos +
                ", Gols Sofridos: " + golsSofridos +
                ", Saldo de Gols: " + golsSaldo;
    }
}
