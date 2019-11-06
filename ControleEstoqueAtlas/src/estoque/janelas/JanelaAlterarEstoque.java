package estoque.janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estoque.classes.Marca;
import estoque.classes.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class JanelaAlterarEstoque implements ActionListener {
	protected JDialog frmProduto;
	protected JTextField tfNome;
	protected JTextField tfQuantidade;
	protected JTextField tfId;
	protected int cod;
	protected Produto produto;
	protected ArrayList <Marca> marcas;
	protected JLabel lblInserirProduto;
	protected JLabel lblNome;
	protected JLabel lblQuantidade;
	protected JButton btnCancelar;
	protected JButton btnConfirmar;
	protected JLabel lblId;
	protected int flagAlt;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//try {
			//JanelaInserirProduto dialog = new JanelaInserirProduto(1, marcas);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		//} catch (Exception e) {
		///	e.printStackTrace();
		//}
	//}

	public Produto getProduto() {
		return produto;
	}
	
	public void setVisible(boolean visible) {
		frmProduto.setVisible(visible);
	}
	
	public JanelaAlterarEstoque(int cod, ArrayList<Marca> marcas) {
		initialize(cod, marcas);
	}
	
	public void initialize(int cod, ArrayList<Marca> marcas) {
		this.marcas = marcas;
		this.cod = cod;
		
		frmProduto = new JDialog();
		frmProduto.setTitle("Inserir Produto");
		frmProduto.setBounds(100, 100, 527, 336);
		frmProduto.getContentPane().setLayout(null);
		frmProduto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmProduto.setModal(true);
		frmProduto.setAlwaysOnTop(true);
		frmProduto.setResizable(false);
		frmProduto.setLocationRelativeTo(null);
		
		
		lblInserirProduto = new JLabel("Alterar Estoque");
		lblInserirProduto.setBounds(180, 36, 143, 14);
		lblInserirProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmProduto.getContentPane().add(lblInserirProduto);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(125, 86, 46, 14);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmProduto.getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setEnabled(false);
		tfNome.setBounds(183, 85, 301, 20);
		frmProduto.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		
		lblQuantidade = new JLabel("Quantidade Atual:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(30, 132, 123, 14);
		frmProduto.getContentPane().add(lblQuantidade);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setEnabled(false);
		tfQuantidade.setBounds(162, 131, 72, 20);
		frmProduto.getContentPane().add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(296, 263, 89, 23);
		frmProduto.getContentPane().add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirmar.addActionListener(this);
		btnConfirmar.setBounds(395, 263, 89, 23);
		frmProduto.getContentPane().add(btnConfirmar);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(30, 88, 27, 14);
		frmProduto.getContentPane().add(lblId);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setText(String.valueOf(cod));
		tfId.setColumns(10);
		tfId.setBounds(56, 85, 38, 20);
		frmProduto.getContentPane().add(tfId);
		
		JLabel lblUndMed = new JLabel("U. Medida:");
		lblUndMed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUndMed.setBounds(244, 134, 79, 14);
		frmProduto.getContentPane().add(lblUndMed);
		
		JLabel lblQuantAlt = new JLabel("Quantidade Alterada:");
		lblQuantAlt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantAlt.setBounds(30, 169, 141, 14);
		frmProduto.getContentPane().add(lblQuantAlt);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 166, 72, 20);
		frmProduto.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("U. Medida:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(271, 169, 79, 14);
		frmProduto.getContentPane().add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnConfirmar) {
			boolean preenchido = true;
			if(tfNome.getText().equals("")) {
				tfNome.setBackground(Color.PINK);
				preenchido = false;
				JOptionPane.showMessageDialog(frmProduto,
						"Preencha o campo de Nome!",
						"Erro!", JOptionPane.ERROR_MESSAGE);
			}else {
				tfNome.setBackground(Color.WHITE);
			}
			
			
			if(tfQuantidade.getText().equals("")) {
				tfQuantidade.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(frmProduto,
						"Preencha o campo de Quantidade!",
						"Erro!", JOptionPane.ERROR_MESSAGE);
				preenchido = false;
			}else {
				tfQuantidade.setBackground(Color.WHITE);
			}
			
			if(preenchido == true) {
				boolean erro = false;
				
				String nomeproduto = tfNome.getText();
				double quantidade = Double.parseDouble(tfQuantidade.getText());

				
				if(quantidade < 0) {
					erro = true;
					JOptionPane.showMessageDialog(frmProduto,
							"nao são permididos numeros negativos no campo de quantidade! ",
							"Erro!", JOptionPane.ERROR_MESSAGE);
				}
				
				if (erro == false) {
					
					//produto = new Produto(cod, nomeproduto, preco, quantidade, und, m);
					if(flagAlt == 1) {
						
						JOptionPane.showMessageDialog(frmProduto, "Produto alterado com Sucesso", "Aviso!",
								JOptionPane.INFORMATION_MESSAGE);
						frmProduto.dispose();
						
					} else {
					JOptionPane.showMessageDialog(frmProduto, "Produto adicionado com Sucesso", "Aviso!",
							JOptionPane.INFORMATION_MESSAGE);
					frmProduto.dispose();
					}
					
				}
			}
			
		}else {
			frmProduto.dispose();
		}
		
 	}
}
