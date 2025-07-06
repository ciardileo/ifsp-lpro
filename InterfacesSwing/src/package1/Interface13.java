package package1;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

// exemplo de árvores com hierarquia
// pg 235

class Interface13  extends JFrame{
   DefaultMutableTreeNode pais;
   DefaultMutableTreeNode estado;
   DefaultMutableTreeNode cidade;
   DefaultMutableTreeNode bairro;
	
   public Interface13() {    
      // criando pais
      pais = new DefaultMutableTreeNode("Brasil");
      
      // adicionando estado
      estado = new DefaultMutableTreeNode("SP");
      pais.add(estado);
      
      // adicionando cidade
      cidade = new DefaultMutableTreeNode("São Paulo");
      estado.add(cidade);
      
      // adicionando bairros
      bairro = new DefaultMutableTreeNode("Pinheiros");
      cidade.add(bairro);
      
      bairro = new DefaultMutableTreeNode("Tatuapé");
      cidade.add(bairro);
      
      bairro = new DefaultMutableTreeNode("Brás");
      cidade.add(bairro);
      
      // adicionando cidade
      cidade = new DefaultMutableTreeNode("Santos");
      estado.add(cidade);
      
      // adicionando bairros
      bairro = new DefaultMutableTreeNode("Centro");
      cidade.add(bairro);
      
      bairro = new DefaultMutableTreeNode("Campo Grande");
      cidade.add(bairro);
      
      bairro = new DefaultMutableTreeNode("Estuário");
      cidade.add(bairro);
      
      // modelo
      DefaultTreeModel modelo = new DefaultTreeModel(pais);
      
      // adicionando o modelo ao JTree:
      JTree arvore = new JTree(modelo);
      getContentPane().add(new JScrollPane(arvore));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(300, 400);   
     }
   
    public static void main(String[] args) {
          new Interface13().setVisible(true);
    }
}     