import javax.swing.*;

public class Interface extends JFrame {

    JButton botao;

    public Interface(){


        setTitle("Teste");
        setSize(600, 200);
        setVisible(true);

        botao = new JButton("Teste");
        add(botao);
        pack();
    }

    public static void main(String[] args) {
        new Interface();
    }

    action
}
