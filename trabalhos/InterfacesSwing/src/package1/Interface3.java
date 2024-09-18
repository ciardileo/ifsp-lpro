package package1;

import javax.swing.*;

// botão com imagem
// pag 188

class Interface3 extends JFrame {
	JButton btn1, btn2, btn3;
	
	public Interface3() {
		setTitle ("Bom Dia Vladmir" );
		setSize (300, 200);
		
		btn1 = new JButton ("Vladimir" );
		btn1.setIcon ( new ImageIcon ("D:/ifsp/ini2/lpro/trabalhos/InterfacesSwing/src/java.jpg") );
		
		btn1.setToolTipText ("Ativa comando" );
		
		btn2 = new JButton ("Camelo" );
		btn2.setIcon ( new ImageIcon ("D:/ifsp/ini2/lpro/trabalhos/InterfacesSwing/src/java2.jpg") );
		
		btn2.setToolTipText ("Ativa comando" );
		
		btn3 = new JButton ("Pinto" );
		btn3.setIcon ( new ImageIcon ("D:/ifsp/ini2/lpro/trabalhos/InterfacesSwing/src/java3.jpg") );
		
		btn3.setToolTipText ("Ativa comando" );
//		btn.setMnemonic ("B");
		
		add (btn1, "South");
		add (btn2, "Center");
		add (btn3, "North");
		setVisible( true );
	}
	
	public static void main(String[] args) {
		new Interface3();
	}
}