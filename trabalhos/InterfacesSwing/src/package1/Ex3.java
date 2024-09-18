package package1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

//ex: Crie um Programa em Java que utilize um JSplitPane sendo que o Frame deverá ser repartido em três partes, desta forma será utilizado um JSplitPane Horizontal e um JSplitPane Vertical
//pg 242

public class Ex3 extends JFrame{
    JPanel panel1, panel2, panel3;
    JLabel label1, label2, label3;
    JSplitPane sp1, sp2;

    public Ex3(){
        // configuracoes do frame
        setTitle("Três painéis");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instancia dos componentes
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        label1 = new JLabel("Área 1");
        label2 = new JLabel("Área 2");
        label3 = new JLabel("Área 3");

        // empacotando os componentes
        panel1.add(label1);
        panel2.add(label2);
        panel3.add(label3);

        sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, panel2, panel3);
        sp2.setOneTouchExpandable(true);

        sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, panel1, sp2);
        sp1.setOneTouchExpandable(true);

        getContentPane().add(sp1);

        // mostrando e dimensionando a janela
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex3();
    }
}
