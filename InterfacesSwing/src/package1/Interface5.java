package package1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

// radio buttons
// pag 200

public class Interface5 extends JFrame implements ActionListener {
	JRadioButton rbYes, rbNo;
	JButton btn;
	ButtonGroup bgOpinion;
	
	public Interface5() {
		rbYes = new JRadioButton("Sim", true);
		rbYes.setActionCommand("Sim");
		rbNo = new JRadioButton("Não");
		rbNo.setActionCommand("Nao");
		bgOpinion = new ButtonGroup();
		bgOpinion.add(rbYes);
		bgOpinion.add(rbNo);
		
		btn = new JButton("Enviar resposta");
		btn.addActionListener(this);
		JPanel p = new JPanel(new GridLayout(3,1));
		TitledBorder titulo = BorderFactory.createTitledBorder("Gostou do atendimento?");
		p.setBorder(titulo);
		p.add(rbYes);
		p.add(rbNo);
		add(p, "Center");
		add(btn, "South");
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt) {
		String resp = bgOpinion.getSelection().getActionCommand();
		JOptionPane.showMessageDialog(null, resp);
	}
	public static void main(String[] args) {
		new Interface5();
	}
}