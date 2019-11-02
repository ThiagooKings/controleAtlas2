package estoque.janelas;

import estoque.classes.*;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ProdutoTable extends AbstractTableModel {

	private ArrayList<Produto> produtos;
	private String[] colunas = new String[] {"ID", "NOME", "PREÇO", "QUANTIDADE", "UND","MARCA"};
	private static final int ID = 0;
	private static final int Nome = 1;
	private static final int Preco = 2;
	private static final int Qnt = 3;
	private static final int Und = 4;
	private static final int Marca = 5;
	
	
	public ProdutoTable() {
		super();
	}

	public ProdutoTable(ArrayList<Produto> produtos, String[] colunas) {
		super();
		this.produtos = produtos;
		this.colunas = colunas;
	}
	
	public Produto getProdutos(int indice) {
		return produtos.get(indice);
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public static int getId() {
		return ID;
	}

	public static int getNome() {
		return Nome;
	}

	public static int getPreco() {
		return Preco;
	}

	public static int getQnt() {
		return Qnt;
	}

	public static int getUnd() {
		return Und;
	}

	public static int getMarca() {
		return Marca;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	@Override
	public int getRowCount() {
		return produtos.size();
	}
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case ID:
			return Integer.class;
		case Nome:
			return String.class;
		case Preco:
			return Double.class;
		case Qnt:
			return Double.class;
		case Und:
			return String.class;
		case Marca:
			return Marca.class;
			
		default: // cloumIndex receber o valor de uma coluna q nao existe
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}}
