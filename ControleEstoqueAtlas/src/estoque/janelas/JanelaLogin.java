package estoque.janelas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JToolBar;

import estoque.classes.Usuario;

import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class JanelaLogin implements ActionListener{

	private JDialog frmLogin;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;
	private JLabel lblUsuario;
	private JButton btnEntrar;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private boolean usuarioExiste;
	private ArrayList<Usuario> usuarios;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
		//	public void run() {
			//	try {
					//JanelaLogin window = new JanelaLogin();
			//		window.frmLogin.setVisible(true);
			//	} catch (Exception e) {
			//		e.printStackTrace();
			//	}
			//}
		//});
	//}
	
	public void setVisible(boolean visible) {
		frmLogin.setVisible(visible);
	}

	public boolean getUsuarioExiste() {
		return usuarioExiste;
	}
	
	public JanelaLogin(ArrayList<Usuario> usuarios) {
		initialize(usuarios);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
		frmLogin = new JDialog();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 249, 212);
		frmLogin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setModal(true);
		frmLogin.setAlwaysOnTop(true);
		frmLogin.setResizable(false);
		frmLogin.setLocationRelativeTo(null);
		
		lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(14, 37, 57, 25);
		frmLogin.getContentPane().add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(14, 84, 46, 25);
		frmLogin.getContentPane().add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(70, 41, 114, 20);
		frmLogin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfSenha = new JPasswordField();
		tfSenha.setBounds(70, 88, 114, 20);
		frmLogin.getContentPane().add(tfSenha);
		tfSenha.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
		btnEntrar.setBounds(81, 131, 89, 23);
		frmLogin.getContentPane().add(btnEntrar);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(103, 11, 62, 19);
		frmLogin.getContentPane().add(lblLogin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnEntrar) {
			boolean preenchido = true;
			if (tfUsuario.getText().equals("")) {
				tfUsuario.setBackground(Color.PINK);
				preenchido = false;
				JOptionPane.showMessageDialog(frmLogin,
						"Preencha o campo de usuário!",
						"Erro!", JOptionPane.ERROR_MESSAGE);
			}else {
				tfUsuario.setBackground(Color.WHITE);
			}
			
			if (tfSenha.getText().equals("")) {
				tfSenha.setBackground(Color.PINK);
				preenchido = false;
				JOptionPane.showMessageDialog(frmLogin,
						"Preencha o campo de senha!",
						"Erro!", JOptionPane.ERROR_MESSAGE);
			}else {
				tfSenha.setBackground(Color.WHITE);
			}
			if (preenchido == true) {
				String usuario = tfUsuario.getText();
				String senha = tfSenha.getText();
				
				
				for(int i=0; i< usuarios.size(); i++) {
					if(usuario.equals(usuarios.get(i).getLogin()) && senha.equals(usuarios.get(i).getSenha())) {			
						usuarioExiste = true;
						JOptionPane.showMessageDialog(frmLogin, "Bem vindo ao sistema de estoque, "+ usuarios.get(i).getNomeUsuario() , "Bem vindo",
								JOptionPane.INFORMATION_MESSAGE);
						frmLogin.dispose();
						break;
					}
					usuarioExiste = false;
					JOptionPane.showMessageDialog(frmLogin,
							"Usuário ou senha incorretos",
							"Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
	}
}
