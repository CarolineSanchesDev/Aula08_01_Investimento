package view;

import business.Aplicacao;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Principal extends JFrame {

    // Alunos:
    // Caroline Sanches
    // Igor Ferreira

    private JLabel lblValor;
    private JLabel lblPrazo;
    private JLabel lblTaxa;
    private JLabel lblResultado;

    private JTextField txtValor;
    private JTextField txtPrazo;

    private JComboBox<String> cbTaxa;

    private JButton btnCalcular;

    public Principal() {

        super("Aula08_01_Investimento");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels
        lblValor = new JLabel("Valor a aplicar (R$):");
        lblPrazo = new JLabel("Prazo (meses):");
        lblTaxa = new JLabel("Indexador:");
        lblResultado = new JLabel("Rendimento: aguardando cálculo...");

        // Campos de texto
        txtValor = new JTextField();
        txtPrazo = new JTextField();

        KeyAdapter somenteNumeros = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();

            if (!Character.isDigit(c)
                    && c != '.'
                    && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
        }
    };

    txtValor.addKeyListener(somenteNumeros);
    txtPrazo.addKeyListener(somenteNumeros);

        // Opções do investimento
        String[] indexadores = {
            "Poupança",
            "CDI",
            "Tesouro Direto"
        };

        cbTaxa = new JComboBox<>(indexadores);

        // Botão
        btnCalcular = new JButton("Calcular Rendimento");

        btnCalcular.addActionListener(e -> {

        try {
            float valor = Float.parseFloat(txtValor.getText());
            int prazo = Integer.parseInt(txtPrazo.getText());

            float taxa = 0f;

            int opcaoSelecionada = cbTaxa.getSelectedIndex();

            if (opcaoSelecionada == 0) {
                taxa = 0.38f;
            } else if (opcaoSelecionada == 1) {
                taxa = 0.53f;
            } else if (opcaoSelecionada == 2) {
                taxa = 0.65f;
            }

            Aplicacao aplicacao = new Aplicacao();

            aplicacao.calcularRendimento(valor, prazo, taxa);

            String resultado = String.format(
                    "Rendimento: R$ %.2f",
                    aplicacao.getMontanteFinal()
            );

            lblResultado.setText(resultado);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Digite valores numéricos válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    });

        // Adiciona os componentes à janela
        add(lblValor);
        add(txtValor);

        add(lblPrazo);
        add(txtPrazo);

        add(lblTaxa);
        add(cbTaxa);

        add(btnCalcular);
        add(lblResultado);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Principal().setVisible(true);
        });

    }

}