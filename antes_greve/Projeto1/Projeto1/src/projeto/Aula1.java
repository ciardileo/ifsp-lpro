package projeto;
import java.awt.*;
import javax.swing.*;


public class Aula1 extends JFrame{

	public Aula1() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int largura = d.width/2;
		int altura = d.height/2;
		setBounds(largura/2, altura/2, largura, altura);
		
		Image img = tk.getImage("teste.png");
		setIconImage(img);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Aula1();
	}
}
