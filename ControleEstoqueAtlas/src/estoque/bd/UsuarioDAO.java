package estoque.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.classes.Marca;
import estoque.classes.Usuario;


public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO (Connection conexao) {
		this.conexao = conexao;
	}
	
	public ArrayList<Usuario> listar() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM tb_usuario";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setIdLogin(rs.getInt("id_usuario"));
				u.setNomeUsuario(rs.getString("nome_usuario"));
				u.setSenha(rs.getString("senha"));
				u.setLogin(rs.getString("login"));
				usuarios.add(u);

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}
