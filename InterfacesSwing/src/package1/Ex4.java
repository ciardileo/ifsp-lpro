package package1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex4 extends JFrame {
    // componentes da interface
    JTabbedPane tabs;
    JPanel pCadastro, pAlteracao, pExclusao, pSelecao;
    JLabel lbNome, lbIdade, lbCPF;
    JButton btnCadastrar, btnAlterar, btnExcluir, btnSelecionar, btnLimpar;
    JTextField txtNome, txtIdade, txtCPF;
    JTable tableCadastro, tableAlteracao, tableExclusao, tableSelecao;
    DefaultTableModel model;
    JScrollPane spCadastro, spAlteracao, spExclusao, spSelecao;

    public Ex4() {
        // config do frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // config dos componentes
        // tabbed pane
        tabs = new JTabbedPane();

        // componentes dos formularios
        pCadastro = new JPanel(new GridLayout(4, 2));
        lbNome = new JLabel("Nome:");
        lbIdade = new JLabel("Idade:");
        lbCPF = new JLabel("CPF:");
        txtNome = new JTextField();
        txtIdade = new JTextField();
        txtCPF = new JTextField();
        btnLimpar = new JButton("Limpar");
        btnCadastrar = new JButton("Cadastrar");

        // modelo da tabela
        String cols[] = {"Nome", "Idade", "CPF"};
        model = new DefaultTableModel(cols, 0);

        // tabelas
        tableCadastro = new JTable(model);
        tableAlteracao = new JTable(model);
        tableExclusao = new JTable(model);
        tableSelecao = new JTable(model);

        // sroll panes
        spCadastro = new JScrollPane(tableCadastro);
        spAlteracao = new JScrollPane(tableAlteracao);
        spExclusao = new JScrollPane(tableExclusao);
        spSelecao = new JScrollPane(tableSelecao);

        // empacotamento do cadastro
        pCadastro.add(lbNome);
        pCadastro.add(txtNome);
        pCadastro.add(lbIdade);
        pCadastro.add(txtIdade);
        pCadastro.add(lbCPF);
        pCadastro.add(txtCPF);
        pCadastro.add(btnCadastrar);
        pCadastro.add(btnLimpar);

        // frame principal e abas
        tabs.addTab("Cadastro", pCadastro);

        // aba de alteracao
        pAlteracao = new JPanel(new GridLayout(2, 1));
        btnAlterar = new JButton("Alterar");
        pAlteracao.add(spAlteracao);
        pAlteracao.add(btnAlterar);
        tabs.addTab("Alteração", pAlteracao);

        // aba de exclusao
        pExclusao = new JPanel(new GridLayout(2, 1));
        btnExcluir = new JButton("Excluir");
        pExclusao.add(spExclusao);
        pExclusao.add(btnExcluir);
        tabs.addTab("Exclusão", pExclusao);

        // aba de selecao
        pSelecao = new JPanel(new GridLayout(2, 1));
        btnSelecionar = new JButton("Selecionar");
        pSelecao.add(spSelecao);
        pSelecao.add(btnSelecionar);
        tabs.addTab("Seleção", pSelecao);

        // adicionar tabs ao frame
        getContentPane().add(tabs);

        // implementação das ações dos botões
        btnCadastrar.addActionListener(e -> cadastro());
        btnLimpar.addActionListener(e -> limpar());
        btnExcluir.addActionListener(e -> excluir());
        btnAlterar.addActionListener(e -> alterar());
        btnSelecionar.addActionListener(e -> selecionar());

        // mostrar a janela
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // funcão de cadastro
    private void cadastro() {
        String nome = txtNome.getText();
        String idade = txtIdade.getText();
        String cpf = txtCPF.getText();

        model.addRow(new Object[]{nome, idade, cpf});

        limpar();

        // msg de sucesso
        JOptionPane.showMessageDialog(this, "Dados adicionados com sucesso!");
    }

    // função para limpar os campos
    private void limpar() {
        txtNome.setText("");
        txtIdade.setText("");
        txtCPF.setText("");
    }

    // função para excluir linha selecionada
    private void excluir() {
        int selectedRow = tableExclusao.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Dado excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione algum dado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // função para editar os dados selecionados
    private void alterar() {
        int selectedRow = tableAlteracao.getSelectedRow();
        if (selectedRow != -1) {
            String nome = (String) model.getValueAt(selectedRow, 0);
            String idade = (String) model.getValueAt(selectedRow, 1);
            String cpf = (String) model.getValueAt(selectedRow, 2);

            JDialog dialogAlterar = new JDialog(this, "Alterar Dados", true);
            dialogAlterar.setSize(300, 200);
            dialogAlterar.setLayout(new GridLayout(4, 2));

            JTextField txtEditNome = new JTextField(nome);
            JTextField txtEditIdade = new JTextField(idade);
            JTextField txtEditCPF = new JTextField(cpf);

            JButton btnSalvar = new JButton("Salvar");

            dialogAlterar.add(new JLabel("Nome:"));
            dialogAlterar.add(txtEditNome);
            dialogAlterar.add(new JLabel("Idade:"));
            dialogAlterar.add(txtEditIdade);
            dialogAlterar.add(new JLabel("CPF:"));
            dialogAlterar.add(txtEditCPF);
            dialogAlterar.add(btnSalvar);

            btnSalvar.addActionListener(e -> {
                model.setValueAt(txtEditNome.getText(), selectedRow, 0);
                model.setValueAt(txtEditIdade.getText(), selectedRow, 1);
                model.setValueAt(txtEditCPF.getText(), selectedRow, 2);

                JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
                dialogAlterar.dispose();
            });

            dialogAlterar.setLocationRelativeTo(this);
            dialogAlterar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione algum dado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // função que mostrar o que ta selecionado na tabela
    private void selecionar() {
        int selectedRow = tableSelecao.getSelectedRow();
        if (selectedRow != -1) {
            String nome = (String) model.getValueAt(selectedRow, 0);
            String idade = (String) model.getValueAt(selectedRow, 1);
            String cpf = (String) model.getValueAt(selectedRow, 2);
    
            String message = String.format("Nome: %s\nIdade: %s\nCPF: %s", nome, idade, cpf);
            JOptionPane.showMessageDialog(this, message, "Dados Selecionados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um dado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Ex4();
    }
}
