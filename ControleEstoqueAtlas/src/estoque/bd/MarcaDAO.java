package estoque.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.classes.Marca;


public class MarcaDAO {
	private Connection conexao;
	
	public MarcaDAO (Connection conexao) {
		this.conexao = conexao;
	}
	
	public ArrayList<Marca> listar() {
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		String sql = "SELECT * FROM tb_marca";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Marca m = new Marca();
				m.setIdMarca(rs.getInt("id_marca"));
				m.setNomeMarca(rs.getString("nome_marca"));
				marcas.add(m);

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}
}
