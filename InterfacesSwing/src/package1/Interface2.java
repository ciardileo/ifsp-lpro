package package1;

import javax.swing.*;

// botões nos pontos cardeais
// pag 187

public class Interface2 extends JFrame {
	JButton btnNorte, btnSul, btnOeste, btnCentro, btnLeste;
	public Interface2() {
		btnNorte = new JButton("Norte");
		btnSul = new JButton("Sul");
		btnOeste = new JButton("Oeste");
		btnCentro = new JButton("Centro");
		btnLeste = new JButton("Leste");
		
		add(btnNorte, "North");
		add(btnSul, "South");
		add(btnOeste, "West");
		add(btnCentro, "Center");
		add(btnLeste, "East");
		
		pack();
		setVisible(true);
	}
	public static void main(String args[]) {
		new Interface2();
	}
}
