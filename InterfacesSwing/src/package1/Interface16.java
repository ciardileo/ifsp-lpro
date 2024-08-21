package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// exemplo usando seletor de arquivo
// pag 253

public class Interface16 extends JFrame {
	public Interface16 () {
		super ("Escolher um diretório usando JFileChooser");
		Container c = getContentPane();
		FlowLayout layout = new FlowLayout (FlowLayout.LEFT); c.setLayout (layout);
		JButton btn = new JButton("Escolher Diretório");
		btn.addActionListener(
				new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						JFileChooser fc = new JFileChooser ();

						//restringe a amostra a diretórios apenas fc.setFileSelectionMode (JFileChooser. DIRECTORIES_ONLY);
						int res = fc.showOpenDialog (null);
						if (res == JFileChooser.APPROVE_OPTION) {
							File diretorio = fc.getSelectedFile();
							JOptionPane.showMessageDialog(null, "Voce escolheu o diretório: " + diretorio.getName());
						} else {
							JOptionPane.showMessageDialog(null, "Você não selecionou um diretório.");
						}
					}
				}
				);
		c.add(btn);
		setSize (400, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Interface16 app = new Interface16 (); app.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}