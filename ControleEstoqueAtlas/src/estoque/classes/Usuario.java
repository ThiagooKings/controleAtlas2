package estoque.classes;

public class Usuario {

private int idLogin;
private String nomeUsuario;
private String senha;
private String login;

public Usuario(int idLogin, String nomeUsuario, String senha, String login) {
	this.idLogin = idLogin;
	this.nomeUsuario = nomeUsuario;
	this.senha = senha;
	this.login = login;
	
}

public Usuario () {
	
}


public int getIdLogin() {
	return idLogin;
}
public void setIdLogin(int idLogin) {
	this.idLogin = idLogin;
}
public String getNomeUsuario() {
	return nomeUsuario;
}
public void setNomeUsuario(String nomeUsuario) {
	this.nomeUsuario = nomeUsuario;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}


	
}
