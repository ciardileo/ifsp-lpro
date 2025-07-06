package package1;

import javax.swing.*;

// exemplo de lista de elementos
// pag 209

import java.awt.event.*;

public class Interface6 extends JFrame implements ActionListener {
	JList lista;
	DefaultListModel modelo;
	JButton btn;
	
	public Interface6() {
		String dados[] = {"Python", "Java", "C++"};
		modelo = new DefaultListModel();
		
		for (String texto:dados) {
			modelo.addElement(texto);
		}

		lista = new JList(modelo);
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane sp = new JScrollPane(lista);
		add(sp, "Center");

		btn = new JButton("Mostrar");
		btn.addActionListener(this);
		add(btn, "South");
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {
		Object selecionados[] = lista.getSelectedValues();
		for (Object texto:selecionados) {
			System.out.println(texto);
		}
	}
	public static void main(String[] args) {
		new Interface6();
	}
}
