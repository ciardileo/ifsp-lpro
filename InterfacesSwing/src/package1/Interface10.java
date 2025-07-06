package package1;

import java.awt.*;
import javax.swing.*;

// exemplos de tipos de cursor
// pag 230

public class Interface10 extends JFrame {
	public Interface10() {
		setLayout(new FlowLayout());
		
		// Botões
		JButton btn1 = new JButton("Cruz");
		JButton btn2 = new JButton("Mão");
		JButton btn3 = new JButton("Movimento");
		JButton btn4 = new JButton("Texto");
		JButton btn5 = new JButton("Espera");
		
		// definição dos cursores
		btn1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn3.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		btn4.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		btn5.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		
		// empacotamento
		add(btn1);
		add(btn2);
	 	add(btn3);
		add(btn4);
		add(btn5);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Interface10( );
	}
}
