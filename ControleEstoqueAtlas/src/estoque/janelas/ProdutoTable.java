package estoque.janelas;

import estoque.classes.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;



public class ProdutoTable extends AbstractTableModel {

	private ArrayList<Produto> linhas;
	private String[] colunas = new String[] {"ID", "NOME", "PREÇO", "QUANTIDADE", "UND","MARCA"};
	private static final int ID = 0;
	private static final int Nome = 1;
	private static final int Preco = 2;
	private static final int Qnt = 3;
	private static final int Und = 4;
	private static final int Marca = 5;
	
	
	public ProdutoTable() {
		super();
		linhas = new ArrayList<Produto>();
		
	}
	
	public ProdutoTable(List<Produto> linhas) {
		super();
		this.linhas = new ArrayList<Produto>(linhas);
	}
	
	public Produto getProduto(int indice) {
		return linhas.get(indice);
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public int getRowCount() {
		return linhas.size();
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
			return String.class;
			
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Produto produto = linhas.get(rowIndex);

		switch (columnIndex) {
		case ID:
			return produto.getIdProduto();
		case Nome:
			return produto.getNomeProduto();
		case Preco:
			return produto.getPreco();
		case Qnt:
			return produto.getQtdestoque();
		case Und:
			return produto.getUndMed();
		case Marca:
			return produto.getMarca().getNomeMarca();

		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
}
