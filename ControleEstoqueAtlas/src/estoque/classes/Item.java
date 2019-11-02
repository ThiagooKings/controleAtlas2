package estoque.classes;


public class Item {

	private int idItem;
	private Produto produto;
	private float  quantidade;
	private float precoItem;
	
	
	public Item() {
	
	}

	public Item(int idItem, Produto produtos, float quantidade, float precoItem) {
		this.idItem = idItem;
		this.produto = produtos;
		this.quantidade = quantidade;
		this.precoItem = precoItem;
		
	}
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Produto getProdutos() {
		return produto;
	}
	public void setProdutos(Produto produtos) {
		this.produto = produtos;
	}
	public double getPrecoItem() {
		return precoItem;
	}
	public void setPrecoItem(float precoItem) {
		this.precoItem = precoItem;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	

}
