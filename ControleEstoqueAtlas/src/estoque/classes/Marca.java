package estoque.classes;

public class Marca {

private int idMarca;
private String nomeMarca;



public Marca(){
	
}
public Marca(int idMarca) {
	this.idMarca = idMarca;
}


public Marca(int idMarca, String nomeMarca) {
	this.idMarca = idMarca;
	this.nomeMarca = nomeMarca;	
}



public int getIdMarca() {
	return idMarca;
}

public void setIdMarca(int idMarca) {
	this.idMarca = idMarca;
}

public String getNomeMarca() {
	return nomeMarca;
}

public void setNomeMarca(String nomeMarca) {
	this.nomeMarca = nomeMarca;
}


	
}
