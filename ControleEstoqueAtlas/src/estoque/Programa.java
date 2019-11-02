package estoque;

import java.sql.Connection;
import estoque.bd.ConnectionFactory;
import estoque.controle.Sistema;



public class Programa {
	private static Sistema sistema;

	public static void main(String[] args) {
		Connection conexao = new ConnectionFactory().getConnection();
		sistema = new Sistema(conexao);

	}


}
