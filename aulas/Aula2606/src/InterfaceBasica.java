import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceBasica extends JFrame implements ActionListener{
    JLabel lblnome = new JLabel();
    JTextField textNome;
    JButton btnClick = new JButton("Clicar");

    // método construtor
    public InterfaceBasica(){
        setTitle("Primeira interface");
        setSize(400, 300);
        setLayout(new FlowLayout());
        
        
        lblnome.setText("Nome: ");
        textNome = new JTextField("", 13);
        btnClick.addActionListener(this);


        add(lblnome);
        add(textNome);
        add(btnClick);

        setVisible(true);
    }


    // método que é chamado quando o arquivo é executado
    public static void main(String[] args){
        System.out.println("Executando");
        new InterfaceBasica();

    }

    public void actionPerformed(ActionEvent ev){
        JOptionPane.showMessageDialog(null, textNome.getText());
    }
}
