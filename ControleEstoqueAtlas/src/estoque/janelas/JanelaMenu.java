package estoque.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaMenu implements ActionListener {
	private JDialog frmMenu;
	private JButton btnSair;

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

	public JanelaMenu() {
		initialize();
	}
	
	public void initialize() {
		frmMenu = new JDialog();
		frmMenu.setBounds(100, 100, 450, 314);
		frmMenu.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmMenu.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(198, 64, 1, 186);
		contentPanel.add(desktopPane);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(175, 23, 46, 14);
		contentPanel.add(lblMenu);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProduto.setBounds(59, 49, 64, 14);
		contentPanel.add(lblProduto);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.setBounds(45, 91, 89, 23);
		contentPanel.add(btnInserir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(45, 137, 89, 23);
		contentPanel.add(btnAlterar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(45, 185, 89, 23);
		contentPanel.add(btnListar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(45, 230, 89, 23);
		contentPanel.add(btnExcluir);
		
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVenda.setBounds(293, 49, 46, 14);
		contentPanel.add(lblVenda);
		
		JButton btnNovaVenda = new JButton("Nova Venda");
		btnNovaVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovaVenda.setBounds(271, 139, 117, 23);
		contentPanel.add(btnNovaVenda);
		
		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(this);
		btnSair.setBounds(335, 241, 89, 23);
		contentPanel.add(btnSair);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnSair) {
			frmMenu.dispose();
		}

		
	}
}
