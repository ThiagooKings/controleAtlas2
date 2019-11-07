package estoque.janelas;

import java.util.ArrayList;

import estoque.classes.Marca;
import estoque.classes.Produto;
import estoque.classes.Usuario;

public class TelaGrafica {
	
	private int opAltEx;
	
	public int getOp(){
		return opAltEx;
	}
	
	public boolean login (ArrayList <Usuario> usuarios) {
		JanelaLogin janela = new JanelaLogin(usuarios);
		janela.setVisible(true);
		if(janela.getUsuarioExiste() == true) {
			return true;
		}
		return false;
		
	}
	
	public int menu() {
		JanelaMenu janela = new JanelaMenu();
		janela.setVisible(true);
		return janela.getOp();
	}
	
	public Produto inserirProduto(int id, ArrayList<Marca> marcas) {
		JanelaInserirProduto janela = new JanelaInserirProduto(id,marcas);
		janela.setVisible(true);
		Produto p = janela.getProduto();
		return p;
	}
	
	public Produto listaProduto(ArrayList<Produto> produtos) {
		JanelaListar janela = new JanelaListar(produtos);
		janela.setVisible(true);
		opAltEx= janela.getOp();
		Produto p = janela.getProdutosel();
		return p;
	}
	
	public Produto alteraProduto(Produto p, ArrayList<Marca> m) {
		JanelaAltera janela = new JanelaAltera(p,m);
		janela.setVisible(true);
		Produto palt = janela.getProduto();
		return palt;
	}
	
	public Produto alterarEstoque(Produto p) {
		JanelaAlterarEstoque janela = new JanelaAlterarEstoque(p);
		janela.setVisible(true);
		Produto palt = janela.getProduto();
		return palt;
	}
	
	

}
