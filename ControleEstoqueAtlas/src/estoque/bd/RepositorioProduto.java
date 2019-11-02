package estoque.bd;

import java.util.ArrayList;

import estoque.classes.Produto;

public class RepositorioProduto {

	ArrayList<Produto> produtos = new ArrayList();
	
	public void inserir(Produto prod) {
		produtos.add(prod);
	}
	
	public void alterar(Produto prod) {
		if (prod != null) {
			for (int i=0; i< produtos.size(); i++) {
				if(produtos.get(i).getIdProduto()== prod.getIdProduto()) {
					produtos.get(i).setNomeProduto(prod.getNomeProduto());
					produtos.get(i).setMarca(prod.getMarca());
					produtos.get(i).setPreco(prod.getPreco());
					produtos.get(i).setQtdestoque(prod.getQtdestoque());
					produtos.get(i).setUndMed(prod.getUndMed());
				}
			}
		}
	}
	
	public ArrayList<Produto> listar(){
		return produtos;
	}
	
	public Produto buscar(int cod) {
		for(int i=0; i<produtos.size(); i++) {
			if(cod == produtos.get(i).getIdProduto()) {
				return produtos.get(i);
			}
		}
		return null;
		
	}
	
	public void excluir(int cod) {
		for(int i=0; i<produtos.size(); i++) {
			if(cod == produtos.get(i).getIdProduto()) {
				produtos.remove(i);
				break; // supondo que nao teremos arquivos repetidos.
			}
		}
		
	}
}
