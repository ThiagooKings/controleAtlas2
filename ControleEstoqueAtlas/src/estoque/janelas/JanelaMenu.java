package estoque.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class JanelaMenu implements ActionListener {
	private JDialog frmMenu;
	private JButton btnSair;
	private JLabel lblMenu;
	private JLabel lblProduto;
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnListar;
	private JButton btnExcluir;
	private JLabel lblEstoque;
	private JButton btnNovo;
	private JButton btnBaixaEstoque;
	private JSeparator separator;
	private int op;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMenu window = new JanelaMenu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int getOp() {
		return op;
	}
	
	public void setVisible(boolean visible) {
		frmMenu.setVisible(visible);
	}

	public JanelaMenu() {
		initialize();
	}
	
	public void initialize() {
		frmMenu = new JDialog();
		frmMenu.setTitle("Sistema de Estoque");
		frmMenu.setBounds(100, 100, 450, 333);
		frmMenu.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmMenu.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		frmMenu.setModal(true);
		frmMenu.setAlwaysOnTop(true);
		frmMenu.setResizable(false);
		frmMenu.setLocationRelativeTo(null);
		
		lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(186, 23, 46, 14);
		contentPanel.add(lblMenu);
		
		lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProduto.setBounds(69, 49, 64, 31);
		contentPanel.add(lblProduto);
		
		btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.addActionListener(this);
		btnInserir.setBounds(33, 91, 130, 35);
		contentPanel.add(btnInserir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.addActionListener(this);
		btnAlterar.setBounds(33, 137, 130, 37);
		contentPanel.add(btnAlterar);
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.addActionListener(this);
		btnListar.setBounds(33, 185, 130, 34);
		contentPanel.add(btnListar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.addActionListener(this);
		btnExcluir.setBounds(33, 230, 130, 34);
		contentPanel.add(btnExcluir);
		
		lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstoque.setBounds(293, 49, 64, 31);
		contentPanel.add(lblEstoque);
		
		btnNovo = new JButton("Adicionar");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.addActionListener(this);
		btnNovo.setBounds(244, 91, 148, 35);
		contentPanel.add(btnNovo);
		
		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(this);
		btnSair.setBounds(335, 260, 89, 23);
		contentPanel.add(btnSair);
		
		btnBaixaEstoque = new JButton("Baixar");
		btnBaixaEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBaixaEstoque.setBounds(244, 138, 148, 35);
		contentPanel.add(btnBaixaEstoque);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(205, 65, 2, 199);
		contentPanel.add(separator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnSair) {
			op=0;
			frmMenu.dispose();
		} else if (o == btnInserir) {
			op = 1;
			frmMenu.dispose();
		} else if (o == btnAlterar || o == btnExcluir || o == btnListar) {
			op = 2;
			frmMenu.dispose();
		} else if(o == btnNovo) {
			op = 3;
			frmMenu.dispose();
		} else {
			op = 4;
			frmMenu.dispose();
		}

		
	}
}
