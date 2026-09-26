package view;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class Principal extends JFrame {

    public Principal() {
        super("Aula08_01_Investimento");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
    }

}