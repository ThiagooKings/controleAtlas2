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
	//private static int proxPorduto;
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
			telaMenu();
		} 
	}
	
	public void telaMenu() {
		int op;
		op = tela.menu();
		if (op == 1) {
			telaInserirProduto();
		} else if( op == 2) {
			telaListarProduto();
		}
	}
	
	public void telaInserirProduto() {
		Produto produto;
		int proxId;
		proxId = pDAO.getProxId();
		
		ArrayList<Marca> marcas = mDAO.listar();
		produto = tela.inserirProduto(proxId, marcas);
		if (produto != null) {
			pDAO.inserir(produto);
			telaMenu();
		}
	}
	
	public void telaListarProduto() {
		ArrayList<Produto> produtos;
		produtos = pDAO.listar();
		Produto p = tela.listaProduto(produtos);
		if(p != null) {
			if(tela.getOp() == 0) {
				System.out.println("foi");
				pDAO.excluir(p);
				telaMenu();
			}
		}
	}

}
