package estoque.controle;

import java.sql.Connection;
import java.util.ArrayList;

import estoque.janelas.TelaGrafica;
import estoque.bd.MarcaDAO;
import estoque.bd.ProdutoDAO;
import estoque.bd.UsuarioDAO;
import estoque.classes.Marca;
import estoque.classes.Produto;
import estoque.classes.Usuario;

public class Sistema {

	private static ProdutoDAO pDAO;
	private static MarcaDAO mDAO;
	private static UsuarioDAO uDAO;
	private static int proxPorduto=0;
	private TelaGrafica tela = new TelaGrafica();

	public Sistema(Connection conexao) {
		mDAO = new MarcaDAO(conexao);
		pDAO = new ProdutoDAO(conexao, mDAO);
		uDAO = new UsuarioDAO(conexao);
		telaLogin();
		
	}
	
	public void telaLogin() {
		boolean ifUsuario;
		ArrayList<Usuario> u = uDAO.listar();
		ifUsuario = tela.login(u);
		if (ifUsuario == true) {
			// chamar janela de menu
			telaMenu();
		} else {
			// mensagem de erro
		}
	}
	
	public void telaMenu() {
		int op;
		op = tela.menu();
		System.out.println(op);
	}

}
