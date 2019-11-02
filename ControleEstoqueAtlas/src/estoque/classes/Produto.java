package estoque.classes;

public class Produto {
	
	private int idProduto;
	private String nomeProduto;
	private double preco;
	private double qtdproduto;
	private String undMed;
	private Marca marca;
	
	public Produto() {
		
	}
	
	public Produto(int idProduto, String nomeProduto, double preco, double qtdestoque, String undMed, Marca marca) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.qtdproduto = qtdestoque;
		this.undMed = undMed;
		this.marca = marca;
	}
	
	public Produto(Marca m) {
		this.marca=m;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getQtdestoque() {
		return qtdproduto;
	}
	public void setQtdestoque(double qtdestoque) {
		this.qtdproduto = qtdestoque;
	}
	public String getUndMed() {
		return undMed;
	}
	public void setUndMed(String undMed) {
		this.undMed = undMed;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}
