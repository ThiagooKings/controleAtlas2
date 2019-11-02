package estoque.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection(){
		//protocolo: jdbc:mysql
		//servidor: localhost
		//databasename(SCHEMA): loja
		//usuario: root
		//senha(do wamp server): 
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/controleestoque", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	//public static void main(String[] args) {
	//	Connection conexao = new ConnectionFactory().getConnection();
	// System.out.println("Conectou");
	// try {
	//	conexao.close();
	//} catch (SQLException e) {
	//	e.printStackTrace();
	//}
	// System.out.println("Desconectado");
	//}
	
}
