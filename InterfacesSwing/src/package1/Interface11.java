package package1;

import java.awt.*; 

//cursor personalizado com imagem
//pg 232

import javax.swing.*; 
public class Interface11 extends JFrame { 
	JButton btn; 
	
	public Interface11() { 
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Image img = tk.getImage("java.png"); 
		setIconImage(img); 
		
		Cursor cursor = tk.createCustomCursor(img, new Point(20, 20), "Oi"); 
		btn = new JButton("Botão Exemplo"); 
		btn.setToolTipText("Teste"); 
		btn.setCursor(cursor); 
		
		add(btn, "North"); 
		setBounds(100,100, 200, 300); 
		setVisible(true);
	}
	
	public static void main(String[] args) { 
		new Interface11(); 
	} 
} 