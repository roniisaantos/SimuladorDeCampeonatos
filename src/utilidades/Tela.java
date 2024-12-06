package utilidades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Tela {

    private static JFrame telaInicial = new JFrame();
    private static JPanel painel = new JPanel();
    private static int definirCampeonato;

    public Tela() {
        telaInicial.setTitle("Simulador de campeonato");
        telaInicial.setSize(400, 600);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setResizable(false);
        telaInicial.setLocationRelativeTo(null);
        telaInicial.add(painel);
        painel.setLayout(new BorderLayout());
        telaInicial.setVisible(true);
    }

    // Exibe a tela inicial de escolha de campeonato
    public void exibirEscolhaCampeonato(Runnable proximaEtapa) {

        JLabel msgInicial = new JLabel("QUAL CAMPEONATO DESEJA SIMULAR:", JLabel.CENTER);
        msgInicial.setFont(new Font("Arial", Font.BOLD, 15));
        painel.add(msgInicial, BorderLayout.NORTH);

        JPanel botoesPainel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton opcao1 = new JButton("Brasileirão Série A 2024");
        JButton opcao2 = new JButton("Brasileirão Série B 2024");

        botoesPainel.add(opcao1);
        botoesPainel.add(opcao2);
        painel.add(botoesPainel, BorderLayout.CENTER);

        // Configurando os ActionListeners
        opcao1.addActionListener(e -> {
            definirCampeonato = 1;
            proximaEtapa.run(); // Chama a próxima etapa
        });

        opcao2.addActionListener(e -> {
            definirCampeonato = 2;
            proximaEtapa.run();
        });

        painel.revalidate();
        painel.repaint();
    }

    public void exibirClassificacao(List<Time> times) {

        painel.removeAll();

        JLabel titulo = new JLabel("Classificação Final", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        painel.add(titulo, BorderLayout.NORTH);

        String[] colunas = {"POS", "Time", "P", "V", "E", "D", "SG", "GF", "GS"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Bloquear edição na tabela após exibição.
            }
        };

        for (int i = 0; i < times.size(); i++) {
            Time time = times.get(i);
            modelo.addRow(new Object[]{
                    i + 1,  // Posição
                    time.nome,
                    time.pontos,
                    time.vitorias,
                    time.empates,
                    time.derrotas,
                    time.golsSaldo,
                    time.golsFeitos,
                    time.golsSofridos
            });
        }

        // Criando a tabela
        JTable tabela = new JTable(modelo);
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.setRowHeight(25);


        // Personalização das colunas
        tabela.getColumnModel().getColumn(0).setPreferredWidth(30); // Posição
        tabela.getColumnModel().getColumn(1).setPreferredWidth(150); // Time
        tabela.getColumnModel().getColumn(2).setPreferredWidth(25); // Pontos
        tabela.getColumnModel().getColumn(3).setPreferredWidth(25); // V
        tabela.getColumnModel().getColumn(4).setPreferredWidth(25); // E
        tabela.getColumnModel().getColumn(5).setPreferredWidth(25); // D
        tabela.getColumnModel().getColumn(6).setPreferredWidth(25); // SG
        tabela.getColumnModel().getColumn(7).setPreferredWidth(25); // GF
        tabela.getColumnModel().getColumn(8).setPreferredWidth(25); // GS

        // Adiciona a tabela à tela dentro de um JScrollPane (para ter rolagem se necessário)
        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane, BorderLayout.CENTER);

        painel.revalidate(); // Atualiza corretamente a interface.
        painel.repaint();
    }

    public int getDefinirCampeonato() {
        return definirCampeonato;
    }
}
