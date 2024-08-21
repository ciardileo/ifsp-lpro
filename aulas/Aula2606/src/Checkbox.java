import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Checkbox extends JFrame implements ActionListener{

    JButton btn;
    JCheckBox chkSport, chkProgramming, chkGames;
    JPanel panel;
    JLabel title;
    
    public Checkbox(){
        title = new JLabel("Choose your interests:");
        chkSport = new JCheckBox("Sports");
        chkProgramming = new JCheckBox("Programming");
        chkGames = new JCheckBox("Games");
        
    }



    public static void main(String[] args) {
        System.out.println("Rodando...");
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Ação");
    }

}
