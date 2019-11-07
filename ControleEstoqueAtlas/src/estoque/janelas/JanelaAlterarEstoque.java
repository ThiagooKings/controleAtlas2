package estoque.janelas;

import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JDialog;

import estoque.classes.Marca;
import estoque.classes.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class JanelaAlterarEstoque implements ActionListener {
	protected JDialog frmEstoque;
	protected JTextField tfNome;
	protected JTextField tfQuantidade;
	protected JTextField tfId;
	protected int cod;
	protected Produto produto;
	protected ArrayList<Marca> marcas;
	protected JLabel lblInserirProduto;
	protected JLabel lblNome;
	protected JLabel lblQuantidade;
	protected JButton btnCancelar;
	protected JButton btnConfirmar;
	protected JLabel lblId;
	protected JTextField tfQuantAlt;
	protected JLabel lblUndMed;
	protected JLabel lblQuantAlt;
	protected JLabel lblUMedida;
	protected JButton btnAdd;
	protected JButton btnBaixa;
	private double qtdAlterada;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// try {
	// JanelaInserirProduto dialog = new JanelaInserirProduto(1, marcas);
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	/// e.printStackTrace();
	// }
	// }

	public Produto getProduto() {
		return produto;
	}

	public void setVisible(boolean visible) {
		frmEstoque.setVisible(visible);
	}

	public JanelaAlterarEstoque(Produto prod) {
		initialize(prod);
	}

	public void initialize(Produto prod) {
		this.produto = prod;
		frmEstoque = new JDialog();
		frmEstoque.setTitle("Alterar Estoque");
		frmEstoque.setBounds(100, 100, 527, 300);
		frmEstoque.getContentPane().setLayout(null);
		frmEstoque.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmEstoque.setModal(true);
		frmEstoque.setAlwaysOnTop(true);
		frmEstoque.setResizable(false);
		frmEstoque.setLocationRelativeTo(null);

		lblInserirProduto = new JLabel("Alterar Estoque");
		lblInserirProduto.setBounds(211, 31, 143, 20);
		lblInserirProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmEstoque.getContentPane().add(lblInserirProduto);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(125, 86, 46, 14);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmEstoque.getContentPane().add(lblNome);

		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setText(String.valueOf(produto.getNomeProduto()));
		tfNome.setBounds(183, 85, 301, 20);
		frmEstoque.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		lblQuantidade = new JLabel("Quantidade Atual:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(30, 132, 123, 14);
		frmEstoque.getContentPane().add(lblQuantidade);

		tfQuantidade = new JTextField();
		tfQuantidade.setEditable(false);
		tfQuantidade.setText(String.valueOf(produto.getQtdestoque()));
		tfQuantidade.setBounds(151, 132, 72, 20);
		frmEstoque.getContentPane().add(tfQuantidade);
		tfQuantidade.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(309, 237, 89, 23);
		frmEstoque.getContentPane().add(btnCancelar);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirmar.addActionListener(this);
		btnConfirmar.setBounds(408, 237, 89, 23);
		frmEstoque.getContentPane().add(btnConfirmar);

		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(30, 88, 27, 14);
		frmEstoque.getContentPane().add(lblId);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setText(String.valueOf(produto.getIdProduto()));
		tfId.setColumns(10);
		tfId.setBounds(56, 85, 38, 20);
		frmEstoque.getContentPane().add(tfId);

		lblUndMed = new JLabel("U. Medida");
		lblUndMed.setText(String.valueOf(produto.getUndMed()));
		lblUndMed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUndMed.setBounds(233, 135, 79, 14);
		frmEstoque.getContentPane().add(lblUndMed);

		lblQuantAlt = new JLabel("Quantidade Alterada:");
		lblQuantAlt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantAlt.setBounds(30, 179, 141, 14);
		frmEstoque.getContentPane().add(lblQuantAlt);

		tfQuantAlt = new JTextField();
		tfQuantAlt.setColumns(10);
		tfQuantAlt.setBounds(172, 173, 72, 20);
		frmEstoque.getContentPane().add(tfQuantAlt);

		lblUMedida = new JLabel("U. Medida");
		lblUMedida.setText(String.valueOf(produto.getUndMed()));
		lblUMedida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUMedida.setBounds(254, 176, 79, 14);
		frmEstoque.getContentPane().add(lblUMedida);

		btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(325, 171, 46, 23);
		btnAdd.addActionListener(this);
		frmEstoque.getContentPane().add(btnAdd);

		btnBaixa = new JButton("-");
		btnBaixa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBaixa.setBounds(381, 171, 46, 23);
		btnBaixa.addActionListener(this);
		frmEstoque.getContentPane().add(btnBaixa);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnAdd) {
			boolean preenchido = true;

			if (tfQuantAlt.getText().equals("")) {
				tfQuantAlt.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(frmEstoque, "Preencha o campo de Quantidade!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
				preenchido = false;
			} else {
				tfQuantAlt.setBackground(Color.WHITE);
			}

			if (preenchido == true) {
				boolean erro = false;

				double quantAlt = Double.parseDouble(tfQuantAlt.getText());
				double quantAtual = Double.parseDouble(tfQuantidade.getText());

				if (quantAlt < 0) {
					erro = true;
					JOptionPane.showMessageDialog(frmEstoque,
							"nao são permididos numeros negativos no campo de quantidade! ", "Erro!",
							JOptionPane.ERROR_MESSAGE);
				}

				if (erro == false) {
					quantAlt = quantAlt + quantAtual;
					tfQuantidade.setText(String.valueOf(quantAlt));
					qtdAlterada = quantAlt;

					// produto = new Produto(cod, nomeproduto, preco, quantidade, und, m);

				}
			}

		} else if (o == btnBaixa) {

			boolean preenchido = true;

			if (tfQuantAlt.getText().equals("")) {
				tfQuantAlt.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(frmEstoque, "Preencha o campo de Quantidade!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
				preenchido = false;
			} else {
				tfQuantAlt.setBackground(Color.WHITE);
			}

			if (preenchido == true) {
				boolean erro = false;

				double quantAlt = Double.parseDouble(tfQuantAlt.getText());
				double quantAtual = Double.parseDouble(tfQuantidade.getText());

				if (quantAlt < 0) {
					erro = true;
					JOptionPane.showMessageDialog(frmEstoque,
							"nao são permididos numeros negativos no campo de quantidade! ", "Erro!",
							JOptionPane.ERROR_MESSAGE);
				}

				if (erro == false) {
					quantAlt = quantAtual - quantAlt;

					if (quantAlt < 0) {
						JOptionPane.showMessageDialog(frmEstoque,
								"O valor de quantidade a retirar é superior ao atua! Nao são permididos numeros negativos no campo de quantidade! ",
								"Erro!", JOptionPane.ERROR_MESSAGE);
					} else {
						qtdAlterada = quantAlt;
						tfQuantidade.setText(String.valueOf(quantAlt));
					}
					// produto = new Produto(cod, nomeproduto, preco, quantidade, und, m);

				}
			}

		} else if (o == btnConfirmar) {
			produto.setQtdestoque(qtdAlterada);
			
			JOptionPane.showMessageDialog(frmEstoque, "Estoque do produto alterado com Sucesso", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
			frmEstoque.dispose();

		} else {
			frmEstoque.dispose();
		}

	}
}
