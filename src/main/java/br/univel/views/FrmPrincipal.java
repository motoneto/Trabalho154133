package br.univel.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import br.univel.Cliente;
import br.univel.DaoImp;
import br.univel.LerArquivo;
import br.univel.ListaClientes;
import br.univel.ListaProdutos;
import br.univel.ListaVenda;
import br.univel.Parser;
import br.univel.Produto;
import br.univel.Serializar;
import br.univel.Venda;
import br.univel.XML;
import br.univel.models.ClienteModel;
import br.univel.models.ProdutoModel;
import br.univel.models.VendaModel;
import br.univel.reports.ReportsActiions;
import net.sf.jasperreports.engine.JRException;

public class FrmPrincipal extends JFrame {

	JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FrmPrincipal frame = new FrmPrincipal();
					frame.setSize(800, 600);
					frame.setTitle("Sistema de Gerenciamento - v1.0");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});
	}

	public FrmPrincipal() {

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JScrollPane jsc = new JScrollPane();
		table = new JTable();
		jsc.setViewportView(table);
		jp.add(jsc, BorderLayout.CENTER);

		this.setJMenuBar(new MenuTop().MenuTop());

		setContentPane(jp);

	}

	class MenuTop extends JFrame {

		public JMenuBar MenuTop() {

			JMenu item;
			JMenuItem subitem;

			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);

			JMenuBar menu = new JMenuBar();

			item = new JMenu("Produto");
			// subitem = new JMenuItem("Cadastrar Produto");
			// item.add(subitem);
			subitem = new JMenuItem("Listar Produtos");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listarProdutos();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar XML");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ImportXmlProdutos();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar TXT");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					importarprodutos();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Exportar XML");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						exportarXmlProduto();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Realizar Backup");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					ExportSerialProdutos();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar Backup");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					ImportSerialProdutos();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Aterar Produto");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					abrirAlterarProduto();
				}
			});
			item.add(subitem);
			menu.add(item);

			// -------------------------------------------------------------------------------------

			item = new JMenu("Cliente");
			// subitem = new JMenuItem("Cadastrar");
			// item.add(subitem);
			subitem = new JMenuItem("Listar Clientes");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listarClientes();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar XML");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ImportXmlClientes();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar TXT");
			item.add(subitem);
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					importarclientes();
				}
			});
			subitem = new JMenuItem("Exportar XML");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					try {
						ExportarXMLclientes();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Realizar Backup");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					ExportSerialClientes();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar Backup");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					ImportSerialClientes();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Aterar Cliente");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					abrirAlterarClientes();
				}
			});
			item.add(subitem);
			menu.add(item);

			// -------------------------------------------------------------------------------------

			item = new JMenu("Vendas");
			subitem = new JMenuItem("Listar Vendas");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					 listarVendas();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar XML");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					 ImportXmlVendas();
				}
			});
			item.add(subitem);
//			subitem = new JMenuItem("Importar TXT");
//			subitem.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent event) {
//					 importarVendas();
//				}
//			});
			item.add(subitem);
			subitem = new JMenuItem("Exportar XML");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					try {
						 ExportarXMLVendas();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Realizar Backup");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					 ExportSerialVendas();
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Importar Backup");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					 ImportSerialVendas();
				}
			});
			item.add(subitem);
			menu.add(item);

			// -------------------------------------------------------------------------------------

			item = new JMenu("Caixa");
			subitem = new JMenuItem("Abrir caixa");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					abrirCaixa();
				}
			});
			item.add(subitem);
			menu.add(item);
			// -------------------------------------------------------------------------------------
			item = new JMenu("Relatorios");
			subitem = new JMenuItem("Relatorio de Vendas");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new ReportsActiions().imprimirVendas();
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			item.add(subitem);
			subitem = new JMenuItem("Relatorio de Produtos");
			subitem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new ReportsActiions().imprimirProdutos();
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			item.add(subitem);
			JMenuItem subitema = new JMenuItem("Relatorio de Clientes");
			subitema.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new ReportsActiions().imprimirClientes();
					} catch (JRException e1) {
						e1.printStackTrace();
					}
				}
			});
			item.add(subitema);
			menu.add(item);

			item = new JMenu("Sair");
			item.addMenuListener(new Sair());
			menu.add(item);

			return menu;

		}

	}

	// Atribui fun��es aos botoes/menus
	protected void importarprodutos() {

		int i = 0;

		i = JOptionPane.showConfirmDialog(null, "Realizar importacao dos dados? ");

		if (i == JOptionPane.YES_OPTION) {

			LerArquivo ler = new LerArquivo();
			List<String> lista = new ArrayList<>();
			lista = ler.lerArquivo("produtos.txt");

			Parser parser = new Parser();
			List<Produto> listaPrd = parser.getProduto(lista);

			ListaProdutos produtos = new ListaProdutos();
			produtos.setLista(listaPrd);
			new DaoImp<>().delete(new Produto());
			new DaoImp<>().create(new Produto());
			listaPrd.forEach(e -> {
				new DaoImp<>().salvar(e);
			});

			JOptionPane.showMessageDialog(null, "Importacao dos produtos realizada!");

		}

	}

	protected void ExportSerialProdutos() {
		List<Produto> Plist = (List) new DaoImp<>().listarTodosProdutos();
		ListaProdutos lp = new ListaProdutos();
		lp.setLista(Plist);
		new Serializar().SerializarProdutos(lp, "Produto.dat");
	}

	protected void ExportSerialClientes() {
		List<Cliente> Clist = (List) new DaoImp<>().listarTodosClientes();
		ListaClientes lc = new ListaClientes();
		lc.setLista(Clist);
		new Serializar().SerializarClientes(lc, "Clientes.dat");
	}
	private void ExportSerialVendas() {
		List<Venda> Vlist = (List) new DaoImp<>().listarTodasVendas();
		ListaVenda lv = new ListaVenda();
		lv.setLista(Vlist);
		new Serializar().SerializarVendas(lv, "Vendas.dat");
	}

	protected void ImportSerialProdutos() {
		new Serializar().ImportSerialProdutos("Produto.dat");
	}

	protected void ImportSerialClientes() {
		new Serializar().ImportSerialClientes("Clientes.dat");
	}
	protected void ImportSerialVendas() {
		new Serializar().ImportSerialVendas("Vendas.dat");
	}

	protected void importarclientes() {

		int i = 0;

		i = JOptionPane.showConfirmDialog(null, "Realizar importacao dos dados? ");

		if (i == JOptionPane.YES_OPTION) {

			LerArquivo ler = new LerArquivo();
			List<String> lista = new ArrayList<>();
			lista = ler.lerArquivo("listaclientes.txt");

			Parser parser = new Parser();
			List<Cliente> listaCli = parser.getCliente(lista);

			ListaClientes clientes = new ListaClientes();
			clientes.setLista(listaCli);
			new DaoImp<>().delete(new Cliente());
			new DaoImp<>().create(new Cliente());
			listaCli.forEach(e -> {
				new DaoImp<>().salvar(e);
			});

			JOptionPane.showMessageDialog(null, "Importacao dos produtos realizada!");

		}

	}

	protected void ImportXmlProdutos() {
		List<Produto> listP = new XML().importarProduto("listaprodutos.xml");
		new DaoImp<>().delete(new Produto());
		new DaoImp<>().create(new Produto());
		listP.forEach(e -> {
			new DaoImp<>().salvar(e);
		});
		ProdutoModel model = new ProdutoModel(listP);
		table.setModel(model);
	}

	protected void ImportXmlClientes() {
		List<Cliente> listC = new XML().importarCliente("listaclientes.xml");
		new DaoImp<>().delete(new Cliente());
		new DaoImp<>().create(new Cliente());
		listC.forEach(e -> {
			new DaoImp<>().salvar(e);
		});
		ClienteModel model = new ClienteModel(listC);
		table.setModel(model);
	}

	private void ImportXmlVendas() {
		List<Venda> listV = new XML().importarVendas("listavendas.xml");
		new DaoImp<>().delete(new Venda());
		new DaoImp<>().create(new Venda());
		listV.forEach(e -> {
			new DaoImp<>().salvar(e);
		});
		VendaModel model = new VendaModel(listV);
		table.setModel(model);
	}


	protected void listarClientes() {
		List<Cliente> Clist = (List) new DaoImp<>().listarTodosClientes();
		ClienteModel model = new ClienteModel(Clist);
		table.setModel(model);
	}

	protected void listarProdutos() {

		List<Produto> Plist = (List) new DaoImp<>().listarTodosProdutos();
		ProdutoModel model = new ProdutoModel(Plist);
		table.setModel(model);

	}

	private void listarVendas() {	
		List<Venda> Vendalist = (List) new DaoImp<>().listarTodasVendas();
		VendaModel model = new VendaModel(Vendalist);
		table.setModel(model);
	}

	protected void ExportarXMLclientes() throws IOException {

		List<Cliente> Plist = (List) new DaoImp<>().listarTodosClientes();

		ListaClientes clientes = new ListaClientes();

		clientes.setLista(Plist);

		new XML().ExportarXML(clientes, "listaclientes.xml");

	}

	private void ExportarXMLVendas() throws IOException {

		List<Venda> Vlist = (List) new DaoImp<>().listarTodasVendas();

		ListaVenda venda = new ListaVenda();

		venda.setLista(Vlist);

		new XML().ExportarXML(venda, "listavendas.xml");
		
	}

	protected void exportarXmlProduto() throws IOException {

		List<Produto> Plist = (List) new DaoImp<>().listarTodosProdutos();

		ListaProdutos produtos = new ListaProdutos();

		produtos.setLista(Plist);

		new XML().ExportarXML(produtos, "listaprodutos.xml");

	}

	protected void abrirCaixa() {
		new FrmCaixa();
	}
	private void abrirAlterarClientes() {
		new FrmClientes();
	}
	private void abrirAlterarProduto() {
		new FrmProdutos();
	}


}

class Sair implements MenuListener {
	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuSelected(MenuEvent arg0) {

		int i = 0;
		i = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar o programa? ");

		if (i == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
}
