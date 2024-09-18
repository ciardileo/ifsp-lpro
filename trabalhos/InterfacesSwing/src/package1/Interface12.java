package package1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

// exemplo de painéis divididos
// pg 240

public class Interface12 extends JFrame{
	public Interface12(){
		setTitle("Exemplo de Split Plane");
		setSize(150,150);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JLabel j1 = new JLabel("Região 1");
		JLabel j2 = new JLabel("Região 2");
		
		panel1.add(j1);
		panel2.add(j2);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,panel1,panel2);
		splitPane.setOneTouchExpandable(true);
		getContentPane().add(splitPane);  
	}

	public static void main(String[] args){
		Interface12 sp = new Interface12();
		
		sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sp.setVisible(true);
	}
}