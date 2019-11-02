package estoque.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.classes.Marca;
import estoque.classes.Produto;


public class ProdutoDAO {

	private Connection conexao;
	private MarcaDAO marcaDAO;

	public ProdutoDAO(Connection conexao, MarcaDAO marcaDAO) {
		this.conexao = conexao;
		this.marcaDAO = marcaDAO;
	}

	public boolean inserir(Produto produto) {

		String sql = "INSERT INTO tb_produto (id_produto, nomeProduto, preco, qntProduto, undMedida, id_marca) VALUES(?,?,?,?,?,?)"; // preencher
		// de // de
		// produto

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// substituir a 1° "?" pelo codigo do objeto produto
			if (produto != null) {
				stmt.setInt(1, produto.getIdProduto());
				// substituir a 2° "?" pelo nome do objeto produto
				stmt.setString(2, produto.getNomeProduto());
				// substituir a 3° "?" pelo preco do objeto produto
				stmt.setDouble(3, produto.getPreco());
				stmt.setDouble(4, produto.getQtdestoque());
				stmt.setString(5, produto.getUndMed());
				stmt.setInt(6, produto.getMarca().getIdMarca());
				// Executar a query no SGDB
				stmt.execute();
				stmt.close();
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean excluir(Produto produto) {
		String sql = "DELETE FROM tb_produto WHERE id_produto = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// substituir a 2° "?" pelo nome do objeto produto
			if (produto != null) {
				stmt.setInt(1, produto.getIdProduto());
				// Executar a query no SGDB
				stmt.execute();
				stmt.close();
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean alterar(Produto produto) {
		String sql = "UPDATE tb_produto SET nomeProduto = ?, preco = ?, qntProduto = ?, undMedida = ?, id_marca = ? WHERE  id_produto = ? ";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, produto.getNomeProduto());
			stmt.setDouble(2, produto.getPreco());
			stmt.setDouble(3, produto.getQtdestoque());
			stmt.setString(4, produto.getUndMed());
			stmt.setInt(5, produto.getMarca().getIdMarca());
			stmt.setInt(6, produto.getIdProduto());
			stmt.execute();
			stmt.close();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Produto> listar() {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT * FROM tb_produto";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			// ResultSet armazena os registros que vieram do BD
			ResultSet rs = stmt.executeQuery();

			// extraindo os registros do ResultSet e criando os objetos apartir
			// destes.

			// next() verifica se tem algum dado (proximo) dentro do ResultSet
			while (rs.next()) {
				Marca m = new Marca(); 
				
				m.setIdMarca(rs.getInt("id_marca"));

				
				Produto p = new Produto();
				p.setIdProduto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nomeProduto"));
				p.setPreco(rs.getDouble("preco"));
				p.setQtdestoque(rs.getDouble("qntProduto"));
				p.setUndMed(rs.getString("undMedida"));
				
				ArrayList<Marca> lista = marcaDAO.listar();
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getIdMarca() == m.getIdMarca()) {
						p.setMarca(lista.get(i));
						break;
					}
				}
				
				produtos.add(p);

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;

	}
	
	
	public int getProxId() {
		String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE TABLE_NAME = 'tb_produto'";
		int id = 1;
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.first())
				id = rs.getInt("AUTO_INCREMENT");
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
}
