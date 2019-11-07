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
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnListar;
	private JButton btnExcluir;
	private JButton btnAlterarEstoque;
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
		frmMenu.setBounds(100, 100, 370, 280);
		frmMenu.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmMenu.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		frmMenu.setModal(true);
		frmMenu.setAlwaysOnTop(true);
		frmMenu.setResizable(false);
		frmMenu.setLocationRelativeTo(null);
		
		lblMenu = new JLabel("Menu Principal");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(127, 25, 148, 23);
		contentPanel.add(lblMenu);
		
		btnInserir = new JButton("Inserir Produto");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.addActionListener(this);
		btnInserir.setBounds(33, 91, 130, 34);
		contentPanel.add(btnInserir);
		
		btnAlterar = new JButton("Alterar Produto");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.addActionListener(this);
		btnAlterar.setBounds(33, 137, 130, 34);
		contentPanel.add(btnAlterar);
		
		btnListar = new JButton("Listar Produtos");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.addActionListener(this);
		btnListar.setBounds(201, 91, 130, 34);
		contentPanel.add(btnListar);
		
		btnExcluir = new JButton("Excluir Produto");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.addActionListener(this);
		btnExcluir.setBounds(201, 138, 130, 34);
		contentPanel.add(btnExcluir);
		
		btnAlterarEstoque = new JButton("Alterar Estoque");
		btnAlterarEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarEstoque.addActionListener(this);
		btnAlterarEstoque.setBounds(33, 185, 130, 34);
		contentPanel.add(btnAlterarEstoque);
		
		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(this);
		btnSair.setBounds(201, 183, 130, 34);
		contentPanel.add(btnSair);
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
		} else if (o == btnAlterar || o == btnExcluir || o == btnListar || o == btnAlterarEstoque) {
			op = 2;
			frmMenu.dispose();
		} else {
			op = 4;
			frmMenu.dispose();
		}

		
	}
}
