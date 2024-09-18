package package1;

import javax.swing.*; import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

// exemplo de JSlider
// pg 257

public class Interface21 extends JFrame{
	JTextField caixa;
	int valor;

	public Interface21(){
		super("Uso do controle JSlider");
		Container tela = getContentPane();
		tela.setLayout (new FlowLayout());
		JLabel rotulo = new JLabel ("Valor:");
		caixa = new JTextField("0", 3);
		caixa.setEditable(false);

		JSlider cDeslizante = new JSlider (JSlider.VERTICAL, 0, 100, 0);
		cDeslizante.setMajorTickSpacing(25);
		cDeslizante.setMinorTickSpacing(5);
		cDeslizante.setPaintTicks (true);
		cDeslizante.setPaintLabels(true);
		cDeslizante.setSnapToTicks(true);
		cDeslizante.addChangeListener(
				new ChangeListener() {
					public void stateChanged (ChangeEvent e){
						JSlider comp = (JSlider) e.getSource();
						if(!comp.getValueIsAdjusting()) {
							valor = comp.getValue();
						}
						caixa.setText((new Integer(valor)).toString());
					};

				});
		
		tela.add(rotulo);
		tela.add(caixa);
		tela.add(cDeslizante);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Interface21 app = new Interface21();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}