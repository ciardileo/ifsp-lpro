package package1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

// exemplo sobre formatação de texto
// pg 261

public class Interface22 extends JFrame{
	private JTextField textField; 
	private JCheckBox boldJCheckBox; 
	private JCheckBox italicJCheckBox; 


	public Interface22(){
		super("Teste de Formatação");
		setLayout(new FlowLayout()); 
		
		textField = new JTextField( "Estilo aplicado!", 20 );
		textField.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
		add( textField );
		
		boldJCheckBox = new JCheckBox( "Bold" ); 
		italicJCheckBox = new JCheckBox( "Italic" ); 
		add( boldJCheckBox ); 
		add( italicJCheckBox ); 

		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener( handler );       
		italicJCheckBox.addItemListener( handler );     
	} 
	
	private class CheckBoxHandler implements ItemListener{
		private int valBold = Font.PLAIN;
		private int valItalic = Font.PLAIN;
	
		public void itemStateChanged( ItemEvent event )	{
			if (event.getSource() == boldJCheckBox) {
				valBold = boldJCheckBox.isSelected()? Font.BOLD : Font.PLAIN;
			}
			
			if (event.getSource() == italicJCheckBox) {
				valItalic = italicJCheckBox.isSelected()? Font.ITALIC : Font.PLAIN;
			}
	
			textField.setFont(new Font("Serif", valBold + valItalic, 14 ));
		}
	} 
	
	public static void main( String args[] ) { 
		Interface22 checkBoxFrame = new Interface22(); 
		checkBoxFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		checkBoxFrame.setSize( 275, 100 ); 
		checkBoxFrame.setVisible( true ); 
	} 
} 