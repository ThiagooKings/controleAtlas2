package estoque.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import estoque.classes.Produto;
import estoque.classes.Marca;

public class JanelaAltera extends JanelaInserirProduto {
	protected static Produto produtoalt;

	public JanelaAltera(Produto p, ArrayList<Marca> m) {
		super(p.getIdProduto(), m);
		flagAlt = 1;
		produtoalt = p;
		frmProduto.setTitle("Alterar Produto");
		tfId.setText(String.valueOf(p.getIdProduto()));
		tfNome.setText(p.getNomeProduto());
		tfPreco.setText(String.valueOf(p.getPreco()));
		tfQuantidade.setText(String.valueOf(p.getQtdestoque()));
		boxUnMedida.setSelectedItem(p.getUndMed());
	    boxMarca.setSelectedItem(p.getMarca().getNomeMarca());


	}


}
