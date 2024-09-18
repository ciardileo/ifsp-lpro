package package1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

// inteface com checkbox que mostra quais foram selecionados ao apertar o botao
// pag 193

public class Interface4 extends JFrame implements ActionListener {
	JCheckBox chkEsportes, chkCulinaria, chkLeitura;
	JButton btn;
	
	public Interface4() {
		
		chkEsportes = new JCheckBox("Esportes");
		chkCulinaria = new JCheckBox("Culinaria");
		chkLeitura = new JCheckBox("Leitura");
		
		btn = new JButton("Clique");
		btn.addActionListener(this);
		
		JPanel p = new JPanel(new GridLayout(3,1));
		TitledBorder titulo = BorderFactory.createTitledBorder("Interesses");
		p.setBorder(titulo);
		
		p.add(chkEsportes);
		p.add(chkCulinaria);
		p.add(chkLeitura);
		
		add(p, "Center");
		add(btn, "South");
		pack();
		setVisible(true);
		setSize(300, 350);
	}
		
	public void actionPerformed(ActionEvent evt) {
		String resp = "Seus interesses:";
		boolean nada = true;
		if (chkEsportes.isSelected()) {
			resp += "\n" + chkEsportes.getText();
			nada = false;
		}
		if (chkCulinaria.isSelected()) {
			resp += "\n" + chkCulinaria.getText();
			nada = false;
		}
		if (chkLeitura.isSelected()) {
			resp += "\n" + chkLeitura.getText();
			nada = false;
		}
		if (nada) {
		JOptionPane.showMessageDialog(null, "Nenhum interesse selecionado");
		} else
			JOptionPane.showMessageDialog(null, resp);
	}
	
	public static void main(String[] args) {
		new Interface4();
	}
}