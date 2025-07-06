package package1;

import java.awt.event.*;
import javax.swing.*;

// menu flutuante
// pg 248

public class Interface15 extends JFrame implements ActionListener {
	private JPopupMenu pop;
	JMenu menu = new JMenu("File");
	JMenuItem itemArquivo = new JMenuItem("Arquivo");
	JMenuItem itemSair = new JMenuItem("Sair");
	JMenuItem Sobre = new JMenuItem("Sobre Menu");

	public Interface15 () {
		super("Popup Menu");
		pop = new JPopupMenu(); pop.add(menu); pop.add (Sobre);

		pop.add("ajuda");
		menu.add(itemArquivo);
		menu.add(itemSair);
		addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent evento) {
						checkForTriggerEvent (evento);
					}

					public void mouseReleased (MouseEvent evento) {
						checkForTriggerEvent (evento);
					}

					private void checkForTriggerEvent (MouseEvent evento) {
						if(evento.isPopupTrigger())
							pop.show(evento.getComponent(), evento.getX(), evento.getY());
					}
				});

		setSize(300, 200);		
		show();
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource ().equals (itemArquivo)) {
			/* executa uma função */
		}
	
		if (e.getSource() == itemSair) {
			/* executa uma função */
		}
		
		if (e.getSource() == Sobre) {
			/* executa uma função */
		}
		
		if (e.getSource() == "ajuda") {
			/* executa uma função */
		}
	}
	
	public static void main (String args[]) {
		Interface15 aplic = new Interface15();
		aplic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}