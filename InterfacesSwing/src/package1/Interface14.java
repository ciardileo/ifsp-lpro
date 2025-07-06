package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// exemplo de tabbed pane
// pg 243

public class Interface14 extends JFrame {
	private JTabbedPane tabs;
	
	public Interface14() {
		super("Abas");
		tabs = new JTabbedPane();
		JPanel jp = new JPanel (new GridLayout (2,2));

		jp.add(new JLabel ("Nome:"));
		jp.add(new JTextField("Digite o seu nome"));
		jp.add(new JLabel ("Número:"));
		jp.add(new JTextField ("Digite o seu número de telefone"));
		tabs.addTab ("Dados pessoais", jp );

		getContentPane().add(tabs);
		jp = new JPanel (new GridLayout (2,2));
		jp.add(new JLabel ("Idade"));
		jp.add(new JTextField ("Digite a Idade"));
		jp.add(new JLabel ("CPF"));
		jp.add(new JTextField ("Digite seu CPF"));
		tabs.addTab ("Dados pessoais 2", jp);
		getContentPane().add(tabs);

		addWindowListener(new WindowAdapter () {
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});

		pack();

		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Interface14();
	}
}