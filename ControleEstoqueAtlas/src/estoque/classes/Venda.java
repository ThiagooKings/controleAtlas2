package estoque.classes;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

	private int idVenda;
	private Date data;
	private ArrayList<Item> itens = new ArrayList();
	private float precoTotal;
	
	
	public Venda() {
		
	}

	public Venda(int idVenda, Date data, ArrayList<Item> itens, float precoTotal) {
		this.idVenda = idVenda;
		this.data = data;
		this.itens = itens;
		this.precoTotal = precoTotal;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public float getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
}
