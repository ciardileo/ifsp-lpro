package projeto;
import javax.swing.*;

public class Exemplo2 extends JFrame{
	JButton btnNorte, btnSul, btnOeste, btnCentro, btnLeste;

	public Exemplo2() {
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
		
	public static void main(String[] args) {
		new Exemplo2();

	}

}
