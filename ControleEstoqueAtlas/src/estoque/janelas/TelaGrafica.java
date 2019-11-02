package estoque.janelas;

import java.util.ArrayList;

import estoque.classes.Produto;
import estoque.classes.Usuario;

public class TelaGrafica {
	
	public boolean login (ArrayList <Usuario> usuarios) {
		JanelaLogin janela = new JanelaLogin(usuarios);
		janela.setVisible(true);
		if(janela.getUsuarioExiste() == true) {
			System.out.println("entrou aaaa");
			return true;
		}
		return false;
		
	}
	
	public int menu() {
		JanelaMenu janela = new JanelaMenu();
		janela.setVisible(true);
		return janela.getOp();
	}
	
	public Produto inserirProduto(int id) {
		JanelaInserirProduto janela = new JanelaInserirProduto(id);
		janela.setVisible(true);
		return janela.getProduto();
	}

}
