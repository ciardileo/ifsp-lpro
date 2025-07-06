package calculadora;
import geometria.calculo.*; 
import calculo.calcular.*;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame {
	private JPanel pVisor, pNumeros, pGeometria;
	private JLabel lblResultado;
	private JTextField txtVisor;
	private JButton btnQuadrado, btnTriangulo, btnRetangulo, btnTrapezio, btnCirculo, btnPonto;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	private JButton btnLog, btnAdicao, btnSubtracao, btnDivisao, btnMultiplicacao, btnRaiz, btnPotencia, btnIgual, btnLimpar, btnBackspace;

	// armazena os números e operações
	private String operador = "";
	private float valor1 = 0;
	private boolean novaOperacao = true;

	public Calculadora() {
		// configuracões
		setTitle("Calculadora");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(new java.awt.Color(25, 26, 28));

		// definindo fonte e cores padrão
		Font fonte = new Font("Arial", Font.PLAIN, 25);
		java.awt.Color corTexto = java.awt.Color.WHITE;

		// criação dos componentes

		// painéis
		pVisor = new JPanel(new BorderLayout());
		pNumeros = new JPanel(new GridLayout(5,4, 10, 10));
		pGeometria = new JPanel(new GridLayout(1, 6, 10, 10));

		pVisor.setBackground(new java.awt.Color(25, 26, 28));
		pNumeros.setBackground(new java.awt.Color(25, 26, 28));
		pGeometria.setBackground(new java.awt.Color(25, 26, 28));

		// margens dos painéis
		pVisor.setBorder(new EmptyBorder(10, 10, 10, 10));
		pGeometria.setBorder(new EmptyBorder(10, 10, 10, 10)); 
		pNumeros.setBorder(new EmptyBorder(10, 10, 10, 10)); 

		// botões geometria
		btnQuadrado = new JButton("\u25A1");
		btnTriangulo = new JButton("\u25B3");
		btnRetangulo = new JButton("\u25AD");
		btnTrapezio = new JButton("\u23E2");
		btnCirculo = new JButton("\u25CB");

		// funções dos botões
		btnQuadrado.addActionListener(e -> quadrado());
		btnTriangulo.addActionListener(e -> triangulo());
		btnRetangulo.addActionListener(e -> retangulo());
		btnTrapezio.addActionListener(e -> trapezio());
		btnCirculo.addActionListener(e -> circulo());

		// configurações do visor
		txtVisor = new JTextField();
		txtVisor.setSize(400, 300);
		txtVisor.setHorizontalAlignment(JTextField.RIGHT);
		txtVisor.setFont(fonte);
		txtVisor.setBackground(new java.awt.Color(25, 26, 28));
		txtVisor.setForeground(corTexto);
		txtVisor.setBorder(null);

		// gpt (listener que observa o teclado e limite a digitação de caracteres que não forem números)
		txtVisor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (c == KeyEvent.VK_ENTER || c == KeyEvent.VK_EQUALS) {
					calcularResultado();
				}

				switch (c) {
				case '/':
					mudarOperacao("/");
					break;

				case 'x':
					mudarOperacao("x");
					break;

				case '*':
					mudarOperacao("x");
					break;

				case '+':
					mudarOperacao("+");
					break;

				case '-':
					mudarOperacao("-");
				}


				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // Impede a digitação de qualquer caractere que não seja número
				}
			}
		});
		
		// label que mostra as contas
		lblResultado = new JLabel("");
		lblResultado.setForeground(corTexto);

		// teclado numérico
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn0 = new JButton("0");
		btnPonto = new JButton(".");

		// ação dos botões numéricos
		btn0.addActionListener(e -> adicionarNum("0"));
		btn1.addActionListener(e -> adicionarNum("1"));
		btn2.addActionListener(e -> adicionarNum("2"));
		btn3.addActionListener(e -> adicionarNum("3"));
		btn4.addActionListener(e -> adicionarNum("4"));
		btn5.addActionListener(e -> adicionarNum("5"));
		btn6.addActionListener(e -> adicionarNum("6"));
		btn7.addActionListener(e -> adicionarNum("7"));
		btn8.addActionListener(e -> adicionarNum("8"));
		btn9.addActionListener(e -> adicionarNum("9"));
		btnPonto.addActionListener(e -> adicionarPonto());

		// botões de operação
		btnLog = new JButton("log");
		btnAdicao = new JButton("+");
		btnSubtracao = new JButton("-");
		btnDivisao = new JButton("/");
		btnMultiplicacao = new JButton("x");
		btnRaiz = new JButton("\u221A");
		btnPotencia = new JButton("^");
		btnIgual = new JButton("=");
		btnLimpar = new JButton("CE");
		btnBackspace = new JButton("\u2190");

		// ação dos botões de oepração
		btnAdicao.addActionListener(e -> mudarOperacao("+"));
		btnSubtracao.addActionListener(e -> mudarOperacao("-"));
		btnMultiplicacao.addActionListener(e -> mudarOperacao("x"));
		btnDivisao.addActionListener(e -> mudarOperacao("/"));
		btnRaiz.addActionListener(e -> calcularRaiz());
		btnPotencia.addActionListener(e -> mudarOperacao("^"));
		btnIgual.addActionListener(e -> calcularResultado());
		btnLimpar.addActionListener(e -> limpar());
		btnBackspace.addActionListener(e -> backspace());
		btnLimpar.addActionListener(e -> txtVisor.setText(""));

		// ajuste do tamanho
		txtVisor.setPreferredSize(new Dimension(400, 100));
		pVisor.setPreferredSize(new Dimension(400, 100)); 
		pGeometria.setPreferredSize(new Dimension(400, 70)); 
		pNumeros.setPreferredSize(new Dimension(400, 400));

		// configuração de estilo dos botões de geometria
		estiloBtnGeometria(btnQuadrado);
		estiloBtnGeometria(btnTriangulo);
		estiloBtnGeometria(btnRetangulo);
		estiloBtnGeometria(btnTrapezio);
		estiloBtnGeometria(btnCirculo);

		// configuração de estilo dos botões numéricos
		estiloBtnNumerico(btn1);
		estiloBtnNumerico(btn2);
		estiloBtnNumerico(btn3);
		estiloBtnNumerico(btn4);
		estiloBtnNumerico(btn5);
		estiloBtnNumerico(btn6);
		estiloBtnNumerico(btn7);
		estiloBtnNumerico(btn8);
		estiloBtnNumerico(btn9);
		estiloBtnNumerico(btn0);
		estiloBtnNumerico(btnPonto);


		// configuração de estilo dos botões de operação
		estiloBtnOperacao(btnAdicao);
		estiloBtnOperacao(btnSubtracao);
		estiloBtnOperacao(btnMultiplicacao);
		estiloBtnOperacao(btnDivisao);
		estiloBtnOperacao(btnIgual);
		estiloBtnNumerico(btnRaiz);
		estiloBtnNumerico(btnPotencia);
		estiloBtnNumerico(btnLimpar);
		estiloBtnNumerico(btnBackspace);


		// empacotamento
		pGeometria.add(btnQuadrado);
		pGeometria.add(btnTriangulo);
		pGeometria.add(btnRetangulo);
		pGeometria.add(btnTrapezio);
		pGeometria.add(btnCirculo);

		pVisor.add(txtVisor, BorderLayout.CENTER);
		pVisor.add(lblResultado, BorderLayout.SOUTH);

		// pNumeros.add(btnLog);
		pNumeros.add(btnRaiz);
		pNumeros.add(btnPotencia);
		pNumeros.add(btnLimpar);
		pNumeros.add(btnBackspace);
		pNumeros.add(btn7);
		pNumeros.add(btn8);
		pNumeros.add(btn9);
		pNumeros.add(btnAdicao);
		pNumeros.add(btn4);
		pNumeros.add(btn5);
		pNumeros.add(btn6);
		pNumeros.add(btnSubtracao);
		pNumeros.add(btn1);
		pNumeros.add(btn2);
		pNumeros.add(btn3); 
		pNumeros.add(btnMultiplicacao);
		pNumeros.add(btnPonto);
		pNumeros.add(btn0);
		pNumeros.add(btnIgual);
		pNumeros.add(btnDivisao); 


		add(pVisor, BorderLayout.NORTH);
		add(pGeometria, BorderLayout.SOUTH);
		add(pNumeros, BorderLayout.CENTER);

		// apresentação
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// funções que aplicam estilo
	private void estiloBtnOperacao(JButton botao) {
		if (!botao.equals(btnRaiz) && !botao.equals(btnBackspace)) {
			botao.setFont(new Font("Arial", Font.PLAIN, 20));
		}

		botao.setBackground(new java.awt.Color(236, 138, 38));
		botao.setForeground(java.awt.Color.WHITE);
		botao.setBorder(null);
	}

	private void estiloBtnNumerico(JButton botao) {
		botao.setFont(new Font("Arial", Font.PLAIN, 20));
		botao.setBackground(new java.awt.Color(56, 57, 59));
		botao.setForeground(java.awt.Color.WHITE);
		botao.setBorder(null);
	}

	private void estiloBtnGeometria(JButton botao) {
		botao.setBackground(new java.awt.Color(111, 115, 118));
		botao.setForeground(java.awt.Color.WHITE);
		botao.setBorder(null);
	}

	// adiciona um número ao visor
	private void adicionarNum(String number) {
		if (novaOperacao) {
			txtVisor.setText(number);
			novaOperacao = false;
		} else {
			txtVisor.setText(txtVisor.getText() + number);
		}
	}

	// lógica do ponto decimal
	private void adicionarPonto() {
		if (novaOperacao) {
			txtVisor.setText("0.");
			novaOperacao = false;
		} else if (!txtVisor.getText().contains(".")) {
			txtVisor.setText(txtVisor.getText() + ".");
		}
	}


	// muda a operação atual
	private void mudarOperacao(String op) {
		try {
			operador = op;
			valor1 = Float.parseFloat(txtVisor.getText());
			txtVisor.setText("");
			lblResultado.setText(String.format("%.2f %s", valor1, op));
			novaOperacao = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ERRO! Digite um número para realizar a operação", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	// calcula o resultado
	private void calcularResultado() {
		try {
			float valor2 = Float.parseFloat(txtVisor.getText());
			float resultado = 0;

			switch (operador) {
			case "+":
				Soma s = new Soma();
				resultado = s.Somar(valor1, valor2);
				break;
			case "-":
				Subtracao d = new Subtracao();
				resultado = d.Subtrair(valor1, valor2);
				break;
			case "x":
				Multiplicacao m = new Multiplicacao();
				resultado = m.Multiplicar(valor1, valor2);
				break;
			case "/":
				if (valor2 != 0) {
					Divisao div = new Divisao();
					resultado = div.Dividir(valor1, valor2);
				} else {
					JOptionPane.showMessageDialog(this, "ERRO! Não é possível dividir por 0", "ERRO", JOptionPane.ERROR_MESSAGE);
					resultado = 0;
				}

				break;
			case "^":
				Potenciacao e = new Potenciacao();
				resultado = e.Potencia(valor1, valor2);
				break;
			}

			txtVisor.setText(String.valueOf(resultado));
			lblResultado.setText(String.format("%.2f %s %.2f = %.2f", valor1, operador, valor2, resultado));
			novaOperacao = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ERRO! DIGITE UM SEGUNDO VALOR PARA A OPERAÇÃO", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	// calcula a raiz do valor no visor
	private void calcularRaiz() {
		double valor = Double.parseDouble(txtVisor.getText());
		if (valor >= 0) {
			double resultado = Math.sqrt(valor);
			txtVisor.setText(String.valueOf(resultado));
			lblResultado.setText(String.format("\u221a %.2f = %.2f", valor, resultado));
		} else{
			JOptionPane.showMessageDialog(this, "ERRO! Raiz de número negativo", "ERRO!", JOptionPane.ERROR_MESSAGE);
		}
	}

	// limpa o visor
	private void limpar() {
		txtVisor.setText("");
		lblResultado.setText("");
		operador = "";
		novaOperacao = true;
	}

	// apaga o último número
	private void backspace() {
		String textoAtual = txtVisor.getText();
		if (textoAtual.length() > 0) {
			txtVisor.setText(textoAtual.substring(0, textoAtual.length() - 1));
		}
	}


	// dialogs dos cálculos geométricos
	public void quadrado() {
		// cria uma instância da classe para fazer as operações
		Quadrado q = new Quadrado(0);

		// criação dos componentes
		JDialog diag = new JDialog(this, "Cálculo com Quadrado", true);
		diag.setLayout(new BorderLayout());
		diag.setSize(340, 130);

		JPanel pContent = new JPanel(new GridLayout(2, 2, 5, 5));
		pContent.setBorder(new EmptyBorder(10, 10, 10, 10)); 

		JLabel lblLado = new JLabel("Lado (m):");
		JTextField txtLado = new JTextField();

		JButton btnArea = new JButton("Calcular Área");
		JButton btnPerimetro = new JButton("Calcular Perímetro");

		// função do botão de area
		btnArea.addActionListener(e -> {
			try {
				q.setLado(Float.parseFloat(txtLado.getText()));
				float resultado = q.area();

				JOptionPane.showMessageDialog(this, "A área do quadrado é " + resultado + " m²", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtLado.setText("");

			}
		});

		// função do botão de perimetro
		btnPerimetro.addActionListener(e -> {
			try {
				q.setLado(Float.parseFloat(txtLado.getText()));
				float resultado = q.perimetro();

				JOptionPane.showMessageDialog(this, "O perímetro do quadrado é " + resultado + " m", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtLado.setText("");

			}
		});


		// empacotamento
		pContent.add(lblLado);
		pContent.add(txtLado);
		pContent.add(btnArea);
		pContent.add(btnPerimetro);

		diag.add(pContent);

		// mostrar a janela
		diag.setLocationRelativeTo(this);
		diag.setVisible(true);

	}

	public void triangulo() {
		// cria uma instância da classe para fazer as operações
		Triangulo t = new Triangulo(0, 0);

		// criação dos componentes
		JDialog diag = new JDialog(this, "Cálculo com Triângulo", true);
		diag.setLayout(new BorderLayout());
		diag.setSize(400, 160);

		JPanel pContent = new JPanel(new GridLayout(3, 2, 5, 5));
		pContent.setBorder(new EmptyBorder(10, 10, 10, 10)); 

		JLabel lblBase = new JLabel("Base (m):");
		JTextField txtBase = new JTextField();

		JLabel lblAltura = new JLabel("Altura (m):");
		JTextField txtAltura = new JTextField();

		JButton btnArea = new JButton("Calcular Área");

		// função do botão de area
		btnArea.addActionListener(e -> {
			try {
				t.setAltura(Float.parseFloat(txtAltura.getText()));
				t.setBase(Float.parseFloat(txtBase.getText()));
				float resultado = t.area();

				JOptionPane.showMessageDialog(this, "A área do triângulo é " + resultado + " m²", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtAltura.setText("");
				txtBase.setText("");

			}
		});


		// empacotamento
		pContent.add(lblAltura);
		pContent.add(txtAltura);
		pContent.add(lblBase);
		pContent.add(txtBase);
		pContent.add(btnArea);

		diag.add(pContent);

		// mostrar a janela
		diag.setLocationRelativeTo(this);
		diag.setVisible(true);

	}

	public void circulo() {
		// cria uma instância da classe para fazer as operações
		Circulo c = new Circulo(0);

		// criação dos componentes
		JDialog diag = new JDialog(this, "Cálculo com Círculo", true);
		diag.setLayout(new BorderLayout());
		diag.setSize(400, 130);

		JPanel pContent = new JPanel(new GridLayout(2, 2, 5, 5));
		pContent.setBorder(new EmptyBorder(10, 10, 10, 10)); 

		JLabel lblRaio = new JLabel("Raio (m):");
		JTextField txtRaio = new JTextField();

		JButton btnArea = new JButton("Calcular Área");
		JButton btnCircunferencia = new JButton("Calcular Circunferência");

		// função do botão de area
		btnArea.addActionListener(e -> {
			try {
				c.setRaio(Float.parseFloat(txtRaio.getText()));
				float resultado = c.area();

				JOptionPane.showMessageDialog(this, "A área do círculo é " + resultado + " m²", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtRaio.setText("");

			}
		});

		// função do botão de circunferencia
		btnCircunferencia.addActionListener(e -> {
			try {
				c.setRaio(Float.parseFloat(txtRaio.getText()));
				float resultado = c.circunferencia();

				JOptionPane.showMessageDialog(this, "A circunferência do círculo é " + resultado + " m", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtRaio.setText("");

			} finally {

			}
		});


		// empacotamento
		pContent.add(lblRaio);
		pContent.add(txtRaio);
		pContent.add(btnArea);
		pContent.add(btnCircunferencia);

		diag.add(pContent);

		// mostrar a janela
		diag.setLocationRelativeTo(this);
		diag.setVisible(true);

	}

	public void retangulo() {
		// cria uma instância da classe para fazer as operações
		Retangulo r = new Retangulo(0, 0);

		// criação dos componentes
		JDialog diag = new JDialog(this, "Cálculo com Retângulo", true);
		diag.setLayout(new BorderLayout());
		diag.setSize(400, 160);

		JPanel pContent = new JPanel(new GridLayout(3, 2, 5, 5));
		pContent.setBorder(new EmptyBorder(10, 10, 10, 10)); 

		JLabel lblBase = new JLabel("Base (m):");
		JTextField txtBase = new JTextField();

		JLabel lblAltura = new JLabel("Altura (m):");
		JTextField txtAltura = new JTextField();

		JButton btnArea = new JButton("Calcular Área");
		JButton btnPerimetro = new JButton("Calcular Perímetro");


		// função do botão de area
		btnArea.addActionListener(e -> {
			try {
				r.setAltura(Float.parseFloat(txtAltura.getText()));
				r.setBase(Float.parseFloat(txtBase.getText()));
				float resultado = r.area();

				JOptionPane.showMessageDialog(this, "A área do retângulo é " + resultado + " m²", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtAltura.setText("");
				txtBase.setText("");

			}
		});

		// função do botão de perímetro
		btnPerimetro.addActionListener(e -> {
			try {
				r.setAltura(Float.parseFloat(txtAltura.getText()));
				r.setBase(Float.parseFloat(txtBase.getText()));
				float resultado = r.perimetro();

				JOptionPane.showMessageDialog(this, "O perímetro do retângulo é " + resultado + " m", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtAltura.setText("");
				txtBase.setText("");

			}
		});


		// empacotamento
		pContent.add(lblAltura);
		pContent.add(txtAltura);
		pContent.add(lblBase);
		pContent.add(txtBase);
		pContent.add(btnArea);
		pContent.add(btnPerimetro);

		diag.add(pContent);

		// mostrar a janela
		diag.setLocationRelativeTo(this);
		diag.setVisible(true);
	}

	public void trapezio() {
		// cria uma instância da classe para fazer as operações
		Trapezio t = new Trapezio(0, 0, 0);

		// criação dos componentes
		JDialog diag = new JDialog(this, "Cálculo com Trapézio", true);
		diag.setLayout(new BorderLayout());
		diag.setSize(450, 200);

		JPanel pContent = new JPanel(new GridLayout(4, 2, 5, 5));
		pContent.setBorder(new EmptyBorder(10, 10, 10, 10)); 

		JLabel lblBaseMaior = new JLabel("Base Maior (m):");
		JTextField txtBaseMaior = new JTextField();

		JLabel lblBaseMenor = new JLabel("Base Menor (m):");
		JTextField txtBaseMenor = new JTextField();

		JLabel lblAltura = new JLabel("Altura (m):");
		JTextField txtAltura = new JTextField();

		JButton btnArea = new JButton("Calcular Área");

		// função do botão de area
		btnArea.addActionListener(e -> {
			try {
				t.setBaseMenor(Float.parseFloat(txtBaseMenor.getText()));
				t.setBaseMaior(Float.parseFloat(txtBaseMaior.getText()));
				t.setAltura(Float.parseFloat(txtAltura.getText()));
				float resultado = t.area();

				JOptionPane.showMessageDialog(this, "A área do trapézio é " + resultado + " m²", "Resultado", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ERRO! Verifique se os números digitados são válidos e tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
				txtBaseMenor.setText("");
				txtBaseMaior.setText("");
				txtAltura.setText("");

			}
		});


		// empacotamento
		pContent.add(lblBaseMenor);
		pContent.add(txtBaseMenor);
		pContent.add(lblBaseMaior);
		pContent.add(txtBaseMaior);
		pContent.add(lblAltura);
		pContent.add(txtAltura);
		pContent.add(btnArea);

		diag.add(pContent);

		// mostrar a janela
		diag.setLocationRelativeTo(this);
		diag.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculadora();
	}
}
