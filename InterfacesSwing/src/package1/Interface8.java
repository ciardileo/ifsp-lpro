package package1;

// exemplo de tabelas
// pag 223

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class Interface8 extends JFrame implements ActionListener {
	JTable tabela;
	DefaultTableModel modelo;
	JButton btn;
	
	public Interface8() {
			String colunas[] = {"Nome", "Estúdio", "Ano"};
			String dados[][] = { {"Batman Arkham: Knight", "Rocksteady", "2015"}, {"Batman Arkham: Origins", "Warner Bros", "2013"} };
			
			modelo = new DefaultTableModel(dados, colunas);
			tabela = new JTable(modelo);
			JScrollPane sp = new JScrollPane(tabela);
			add(sp, "Center");
			
			btn = new JButton("Selecionar");
			btn.addActionListener(this);
			add(btn, "South");
			pack();
			setVisible(true);
	}
public void actionPerformed(ActionEvent evt) {
		int linha = tabela.getSelectedRow();
		int coluna = tabela.getSelectedColumn();
		if (linha != -1 && coluna != -1) {
		  String dado = (String)tabela.getValueAt(linha, coluna);
			JOptionPane.showMessageDialog(this, dado);
		} else {
			JOptionPane.showMessageDialog(this, "Sem seleção");
		}
	}
	public static void main(String[] args) {
		new Interface8();
	}
}

		
			