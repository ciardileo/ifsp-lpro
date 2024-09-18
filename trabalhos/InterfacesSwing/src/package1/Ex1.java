package package1;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

// ex de arvores 
// pg 238

public class Ex1 extends JFrame{
	DefaultMutableTreeNode nivel1;
	DefaultMutableTreeNode nivel2;
	DefaultMutableTreeNode nivel3;
	DefaultMutableTreeNode nivel4;

	public Ex1(){
		// criando a hierarquia
		nivel1 = new DefaultMutableTreeNode("FIFA");
		nivel2 = new DefaultMutableTreeNode("CBF");
		nivel3 = new DefaultMutableTreeNode("Federação Paulista de Futebol");
		nivel4 = new DefaultMutableTreeNode("São Paulo");

		nivel1.add(nivel2);
		nivel2.add(nivel3);
		nivel3.add(nivel4);

		// modelo
		DefaultTreeModel modelo = new DefaultTreeModel(nivel1);

		// arvore
		JTree arvore = new JTree(modelo);
		add(arvore);
		setSize(300, 400); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex1();
	}
}
