package projeto;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame{
	
	public App() {
		setTitle("Interface 1 ");
		setVisible(true);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();

		int largura = d.width/2;
		int altura = d.height/2;

		setBounds(largura/2, altura/2, largura, altura);
		Image img = tk.getImage("fig.gif");
		setIconImage(img);

	}

	public static void main(String[] args) {
		new App();
	}

}
