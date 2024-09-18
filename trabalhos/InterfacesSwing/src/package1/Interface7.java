package package1;

import javax.swing.*;
import java.awt.event.*;

// exemplo usando combo box
// pag 216

public class Interface7 extends JFrame implements ActionListener {
	JComboBox combo;
	JButton btn;
	JLabel titulo;
	
	public Interface7() {
		titulo = new JLabel("Selecione seu time:");
		add(titulo, "North");
		
		String dados[] = {"São Paulo", "Corinthians", "Palmeiras"};
		combo = new JComboBox(dados);
		combo.setSelectedIndex(1);
		combo.setMaximumRowCount(3);
		add(combo, "Center");

		btn = new JButton("Selecionar");
		btn.addActionListener(this);
		add(btn, "South");
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {
		Object selecionado = combo.getSelectedItem();
		JOptionPane.showMessageDialog(null, selecionado);
	}
	public static void main(String[] args) {
		new Interface7();
	}
}
