package projeto;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class PrimeiraInterface extends JFrame{

	public PrimeiraInterface() {
		setTitle("App");
		setSize(500, 400);
		setVisible(true);
		setLayout(new FlowLayout());
		
	}

	public static void main(String[] args) {
		System.out.println("Teste");
		new PrimeiraInterface();
		
	}

}
