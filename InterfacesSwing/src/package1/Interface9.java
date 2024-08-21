package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// menu de escolha de cor
// pag 226

public class Interface9 extends JFrame implements ActionListener {
	JButton btn;
	
	public Interface9() {
		btn = new JButton("Clique");
		btn.addActionListener(this);
		
		getContentPane().add(btn, "West");
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Color corAtual = btn.getBackground();
		Color novaCor = JColorChooser.showDialog(Interface9.this, 
						"Escolha a cor", corAtual);
		btn.setBackground(novaCor);
	}
	
	public static void main ( String args [ ] ) {
		new Interface9();
	}
}