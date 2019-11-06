package estoque.janelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import estoque.classes.Produto;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JanelaListaEstoque implements ActionListener, ListSelectionListener {
	protected JTable tbProdutos;
	protected ProdutoTable tmProdutos;
	protected JDialog frmListar;
	protected JScrollPane scroll;
	protected JPanel panelBotoes;
	protected JButton btFechar;
	private JButton btAddestoque;
	private JButton btBaixaestoque;
	private Produto produtoSel;
	private ArrayList<Produto> todosProdutos;

	private JLabel lblOrdenarPor;
	private JRadioButton rdbtnCdigo;
	private JRadioButton rdbtnNomeProduto;
	private JRadioButton rdbtnPreco;
	private JRadioButton rdbtnQnt;
	private JRadioButton rdbtnUmedida;
	private JRadioButton rdbtnMarca;

	private JLabel lblProcurarPor;
	private JTextField tfprocurar;
	private JButton btnProcurar;
	private int opBaixAlta;
	private TableRowSorter<ProdutoTable> sorter;

	public JanelaListaEstoque(ArrayList<Produto> produtos) {
		todosProdutos = produtos;
		initGUI(todosProdutos);
	}

	public Produto getProdutosel() {
		return produtoSel;
	}

	public void setVisible(boolean visible) {
		frmListar.setVisible(visible);
	}

	public int getOp() {
		return opBaixAlta;
	}

	public void constroiTabela() {

		tbProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// tamanhho da coluna em pixels
		tbProdutos.getColumnModel().getColumn(0).setPreferredWidth(60);
		// se a coluna é redimensionavel
		tbProdutos.getColumnModel().getColumn(0).setResizable(true);
		tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbProdutos.getColumnModel().getColumn(1).setResizable(true);
		tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(120);
		tbProdutos.getColumnModel().getColumn(2).setResizable(true);
		tbProdutos.getColumnModel().getColumn(3).setPreferredWidth(120);
		tbProdutos.getColumnModel().getColumn(3).setResizable(true);
		tbProdutos.getColumnModel().getColumn(4).setPreferredWidth(90);
		tbProdutos.getColumnModel().getColumn(4).setResizable(true);
		tbProdutos.getColumnModel().getColumn(5).setPreferredWidth(150);
		tbProdutos.getColumnModel().getColumn(5).setResizable(true);

		// possibilidade de reordenar as colunas
		tbProdutos.getTableHeader().setReorderingAllowed(false);
		frmListar.getContentPane().setLayout(null);
		tbProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scroll = new JScrollPane(tbProdutos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(33, 167, 469, 239);
		// panel.add(scroll);
		// scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// scroll.setViewportView(tbProdutos);
		frmListar.getContentPane().add(scroll);
	}

	private void initGUI(ArrayList<Produto> produtos) {
		frmListar = new JDialog();
		frmListar.setTitle("Lista Produtos");
		frmListar.setModal(true);
		frmListar.setSize(550, 500);
		frmListar.setAlwaysOnTop(true);
		frmListar.setResizable(false);
		frmListar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmListar.setLocationRelativeTo(null);
		// BorderLayout l = (BorderLayout) frame.getContentPane().getLayout();
		// l.setHgap(10);
		// l.setVgap(10);

		tmProdutos = new ProdutoTable(todosProdutos);

		tbProdutos = new JTable();
		tbProdutos.setModel(tmProdutos);
		sorter = new TableRowSorter<ProdutoTable>(tmProdutos);
		tbProdutos.setRowSorter(sorter);

		constroiTabela();

		panelBotoes = new JPanel();
		panelBotoes.setBounds(0, 417, 544, 43);
		FlowLayout layout = (FlowLayout) panelBotoes.getLayout();
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setAlignment(FlowLayout.RIGHT);
		frmListar.getContentPane().add(panelBotoes);

		tbProdutos.getSelectionModel().addListSelectionListener(this);
		btAddestoque = new JButton("Adicionar Estoque");
		btAddestoque.setEnabled(false);
		btAddestoque.addActionListener(this);
		panelBotoes.add(btAddestoque);

		tbProdutos.getSelectionModel().addListSelectionListener(this);
		btBaixaestoque = new JButton("Baixar Estoque");
		btBaixaestoque.setEnabled(false);
		btBaixaestoque.addActionListener(this);
		panelBotoes.add(btBaixaestoque);

		btFechar = new JButton("Fechar");
		btFechar.setEnabled(true);
		btFechar.setBounds(438, 51, 89, 23);
		btFechar.addActionListener(this);
		panelBotoes.add(btFechar);

		JLabel lblListarAlunos = new JLabel("Listagem de Produtos");
		lblListarAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListarAlunos.setBounds(193, 5, 176, 23);
		frmListar.getContentPane().add(lblListarAlunos);

		lblOrdenarPor = new JLabel("Procurar Por:");
		lblOrdenarPor.setBounds(10, 59, 79, 14);
		frmListar.getContentPane().add(lblOrdenarPor);

		ButtonGroup bg = new ButtonGroup();

		rdbtnCdigo = new JRadioButton("C\u00F3digo");
		rdbtnCdigo.setSelected(true);
		rdbtnCdigo.setBounds(100, 55, 64, 23);
		rdbtnCdigo.addActionListener(this);
		bg.add(rdbtnCdigo);
		frmListar.getContentPane().add(rdbtnCdigo);

		rdbtnNomeProduto = new JRadioButton("Nome Produto");
		rdbtnNomeProduto.setSelected(false);
		rdbtnNomeProduto.setBounds(181, 55, 109, 23);
		rdbtnNomeProduto.addActionListener(this);
		bg.add(rdbtnNomeProduto);
		frmListar.getContentPane().add(rdbtnNomeProduto);

		rdbtnPreco = new JRadioButton("Preço");
		rdbtnPreco.setSelected(false);
		rdbtnPreco.setBounds(292, 55, 79, 23);
		rdbtnPreco.addActionListener(this);
		bg.add(rdbtnPreco);
		frmListar.getContentPane().add(rdbtnPreco);

		rdbtnQnt = new JRadioButton("Quantidade");
		rdbtnQnt.setSelected(false);
		rdbtnQnt.setBounds(373, 55, 96, 23);
		rdbtnQnt.addActionListener(this);
		bg.add(rdbtnQnt);
		frmListar.getContentPane().add(rdbtnQnt);

		rdbtnUmedida = new JRadioButton("U. Med.");
		rdbtnUmedida.setSelected(false);
		rdbtnUmedida.setBounds(100, 87, 79, 23);
		rdbtnUmedida.addActionListener(this);
		bg.add(rdbtnUmedida);
		frmListar.getContentPane().add(rdbtnUmedida);

		rdbtnMarca = new JRadioButton("Marca");
		rdbtnMarca.setSelected(false);
		rdbtnMarca.setBounds(181, 87, 79, 23);
		rdbtnMarca.addActionListener(this);
		bg.add(rdbtnMarca);
		frmListar.getContentPane().add(rdbtnMarca);

		lblProcurarPor = new JLabel("Pesquisar Por:");
		lblProcurarPor.setBounds(10, 135, 90, 14);
		frmListar.getContentPane().add(lblProcurarPor);

		tfprocurar = new JTextField();
		// tfprocurar.setText("0");
		tfprocurar.setBounds(100, 133, 314, 20);
		frmListar.getContentPane().add(tfprocurar);
		tfprocurar.setColumns(10);

		btnProcurar = new JButton("Procurar");
		btnProcurar.setEnabled(true);
		btnProcurar.setBounds(428, 133, 89, 23);
		btnProcurar.addActionListener(this);
		frmListar.getContentPane().add(btnProcurar);

	}

	public void filtragemColuna(int col) {
		String text = tfprocurar.getText();
		if (text.length() == 0) {
			sorter.setRowFilter(null);
		} else {
			try {
				sorter.setRowFilter(RowFilter.regexFilter(text, col));
			} catch (PatternSyntaxException pse) {
				System.err.println("Erro");
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btFechar) {
			frmListar.dispose();
		} else if (o == btBaixaestoque) {
			int linhaSel = tbProdutos.getSelectedRow();
			opBaixAlta = 0;
			produtoSel = tmProdutos.getProduto(linhaSel);
			
			frmListar.setAlwaysOnTop(false);
			frmListar.dispose();

		} else if (o == btAddestoque) {
			int linhaSel = tbProdutos.getSelectedRow();
			produtoSel = tmProdutos.getProduto(linhaSel);
			opBaixAlta = 1;
			frmListar.dispose();
		} else if (o == btnProcurar) {
			if (rdbtnNomeProduto.isSelected()) {
				filtragemColuna(1);
			} else if (rdbtnCdigo.isSelected()) {
				filtragemColuna(0);
			} else if (rdbtnPreco.isSelected()) {
				filtragemColuna(2);
			} else if (rdbtnQnt.isSelected()) {
				filtragemColuna(3);
			} else if (rdbtnUmedida.isSelected()) {
				filtragemColuna(4);
			} else if (rdbtnMarca.isSelected()) { // testar se vai dar certo dps!!
				filtragemColuna(5);
			}

		}
	}

	// public static void main(String[] args) {
	// List<Aluno> alun = new ArrayList<Aluno>();

	// JanelaAlunoLista j = new JanelaAlunoLista(alun,
	// JanelaAlunoLista.COMSELECAOALTERAR);
	// j.setVisible(true);
	// }

	@Override
	// o Metodo valueChanged sera exexutado toda vez q uma linha for selecionada
	// no JTable
	public void valueChanged(ListSelectionEvent e) {
		btBaixaestoque.setEnabled(true); // ativando o botao
		btAddestoque.setEnabled(true);
	}
}
