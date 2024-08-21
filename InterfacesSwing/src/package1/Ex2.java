package package1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

//ex: criar um programa que utilize JSplitPane horizontal
//pg 242

public class Ex2 extends JFrame{
    // atribtuos de classe
    JPanel painel1, painel2;
    JLabel label1, label2;
    JSplitPane splitPane;

    // construtor
    public Ex2(){
        // caracteristicas do frame
        setTitle("SplitPane horizontal");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instanciando os componentes
        painel1 = new JPanel();
        painel2 = new JPanel();

        label1 = new JLabel("Este é o painel 1");
        label2 = new JLabel("Este é o painel 2");

        // adicionando componentes ao painel
        painel1.add(label1);
        painel2.add(label2);

        // adicionando painéis ao frame
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, painel1, painel2);
        splitPane.setOneTouchExpandable(true);
        getContentPane().add(splitPane);  

        // exibindo e redimensionando o frame
        setLocationRelativeTo(null);  // centraliza a janela 
        setVisible(true);
    }

    // método executor
    public static void main(String[] args) {
        new Ex2();
    }
}
