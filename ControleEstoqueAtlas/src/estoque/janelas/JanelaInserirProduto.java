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

public class JanelaInserirProduto implements ActionListener {
	protected JDialog frmProduto;
	protected JTextField tfNome;
	protected JTextField tfPreco;
	protected JTextField tfQuantidade;
	protected JTextField tfId;
	protected int cod;
	protected Produto produto;
	protected ArrayList <Marca> marcas;
	protected JLabel lblInserirProduto;
	protected JLabel lblNome;
	protected JLabel lblMarca;
	protected JComboBox boxMarca;
	protected JLabel lblPreco;
	protected JLabel lblUnidadeDeMedida;
	protected JComboBox boxUnMedida;
	protected JLabel lblQuantidade;
	protected JButton btnCancelar;
	protected JButton btnConfirmar;
	protected JLabel lblId;
	protected int flagAlt;

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
	
	public JanelaInserirProduto(int cod, ArrayList<Marca> marcas) {
		initialize(cod, marcas);
	}
	
	public void initialize(int cod, ArrayList<Marca> marcas) {
		this.marcas = marcas;
		this.cod = cod;
		
		frmProduto = new JDialog();
		frmProduto.setTitle("Inserir Produto");
		frmProduto.setBounds(100, 100, 540, 352);
		frmProduto.getContentPane().setLayout(null);
		frmProduto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmProduto.setModal(true);
		frmProduto.setAlwaysOnTop(true);
		frmProduto.setResizable(false);
		frmProduto.setLocationRelativeTo(null);
		
		
		lblInserirProduto = new JLabel("Inserir Produto");
		lblInserirProduto.setBounds(216, 23, 133, 14);
		lblInserirProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmProduto.getContentPane().add(lblInserirProduto);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(125, 86, 46, 14);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmProduto.getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(183, 85, 140, 20);
		frmProduto.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(333, 88, 46, 14);
		frmProduto.getContentPane().add(lblMarca);
		
		boxMarca = new JComboBox();
		for(int i =0; i<this.marcas.size(); i++) {
			boxMarca.addItem(this.marcas.get(i).getNomeMarca());
		}
		boxMarca.setBounds(384, 85, 100, 20);
		frmProduto.getContentPane().add(boxMarca);
		
		lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(30, 143, 46, 14);
		frmProduto.getContentPane().add(lblPreco);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(88, 142, 110, 20);
		frmProduto.getContentPane().add(tfPreco);
		tfPreco.setColumns(10);
		
		lblUnidadeDeMedida = new JLabel("Unidade de Medida:");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnidadeDeMedida.setBounds(264, 142, 119, 20);
		frmProduto.getContentPane().add(lblUnidadeDeMedida);
		
		boxUnMedida = new JComboBox();
		boxUnMedida.setBounds(395, 142, 54, 20);
		boxUnMedida.addItem("cx");
		boxUnMedida.addItem("lt");
		boxUnMedida.addItem("kg");
		boxUnMedida.addItem("pct");
		boxUnMedida.addItem("und");
		boxUnMedida.addItem("g");
		frmProduto.getContentPane().add(boxUnMedida);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(30, 205, 86, 14);
		frmProduto.getContentPane().add(lblQuantidade);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(126, 204, 72, 20);
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
			
			if(tfPreco.getText().equals("")) {
				tfPreco.setBackground(Color.PINK);
				preenchido = false;
				JOptionPane.showMessageDialog(frmProduto,
						"Preencha o campo de Preço!",
						"Erro!", JOptionPane.ERROR_MESSAGE);
			}else {
				tfPreco.setBackground(Color.WHITE);
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
				double preco = Double.parseDouble(tfPreco.getText());
				String nomemarca = (String) boxMarca.getSelectedItem();
				String und = (String) boxUnMedida.getSelectedItem();
				
				if(quantidade < 0) {
					erro = true;
					JOptionPane.showMessageDialog(frmProduto,
							"Não são permitidos números negativos no campo de Quantidade! ",
							"Erro!", JOptionPane.ERROR_MESSAGE);
				}
				if(preco < 0) {
					erro = true;
					JOptionPane.showMessageDialog(frmProduto,
							"Não são permididos números negativos no campo de Preço! ",
							"Erro!", JOptionPane.ERROR_MESSAGE);
				}
				
				if (erro == false) {
					Marca m = new Marca();
					for (int i =0; i<marcas.size();i++) {
						if(marcas.get(i).getNomeMarca().equals(nomemarca)) {
							m = marcas.get(i);
						}
					}
					produto = new Produto(cod, nomeproduto, preco, quantidade, und, m);
					if(flagAlt == 1) {
						
						JOptionPane.showMessageDialog(frmProduto, "Produto alterado com sucesso", "Aviso!",
								JOptionPane.INFORMATION_MESSAGE);
						frmProduto.dispose();
						
					} else {
					JOptionPane.showMessageDialog(frmProduto, "Produto adicionado com sucesso", "Aviso!",
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
