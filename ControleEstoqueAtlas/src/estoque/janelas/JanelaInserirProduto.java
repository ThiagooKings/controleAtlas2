package estoque.janelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estoque.classes.Produto;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class JanelaInserirProduto extends JDialog {
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JTextField textField;
	private int cod;
	private Produto produto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaInserirProduto dialog = new JanelaInserirProduto(1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Produto getProduto() {
		return produto;
	}
	
	public JanelaInserirProduto(int cod) {
		initialize(cod);
	}
	
	public void initialize(int cod) {
		this.cod = cod;
		setTitle("Inserir Produto");
		setBounds(100, 100, 527, 336);
		getContentPane().setLayout(null);
		
		JLabel lblInserirProduto = new JLabel("Inserir Produto");
		lblInserirProduto.setBounds(180, 36, 116, 14);
		lblInserirProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblInserirProduto);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(125, 86, 46, 14);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(183, 85, 140, 20);
		getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(333, 88, 46, 14);
		getContentPane().add(lblMarca);
		
		JComboBox BoxMarca = new JComboBox();
		BoxMarca.setBounds(384, 85, 100, 20);
		getContentPane().add(BoxMarca);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(30, 143, 46, 14);
		getContentPane().add(lblPreco);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(88, 142, 110, 20);
		getContentPane().add(tfPreco);
		tfPreco.setColumns(10);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida:");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnidadeDeMedida.setBounds(264, 142, 119, 20);
		getContentPane().add(lblUnidadeDeMedida);
		
		JComboBox BoxUnMedida = new JComboBox();
		BoxUnMedida.setBounds(395, 142, 44, 20);
		getContentPane().add(BoxUnMedida);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(30, 205, 86, 14);
		getContentPane().add(lblQuantidade);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(126, 204, 72, 20);
		getContentPane().add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(296, 263, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirmar.setBounds(395, 263, 89, 23);
		getContentPane().add(btnConfirmar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(30, 88, 27, 14);
		getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(56, 85, 38, 20);
		getContentPane().add(textField);
	}
}
