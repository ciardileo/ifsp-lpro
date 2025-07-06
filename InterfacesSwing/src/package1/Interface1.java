package package1;

import java.awt.*;
import javax.swing.*;

// cria uma janela com metade do tamanho da tela e coloca uma imagem no ícone
// pag 168

public class Interface1 extends JFrame {
	public Interface1() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int largura = d.width/2;
		int altura =  d.height/2;
		
		setBounds(largura/2, altura/2, largura, altura);
		Image img = tk.getImage("D:/ifsp/ini2/lpro/trabalhos/InterfacesSwing/src/spfc.png");
		
		setIconImage(img);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Interface1();
	}
}