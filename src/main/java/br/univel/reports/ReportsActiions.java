package br.univel.reports;

import javax.swing.JFrame;

import br.univel.DaoImp;
import br.univel.ListaProdutos;
import br.univel.ListaVenda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportsActiions {
	private void Imprimir() throws JRException {
		
	}

	public void imprimirProdutos() throws JRException {
		
		String arq = "RelatorioProdutos.jasper";
		DaoImp d = new DaoImp();
		ListaProdutos dao = new ListaProdutos();
		ProdutoJRDataSource ds = new ProdutoJRDataSource(dao.getLista());
		JasperPrint jp = JasperFillManager.fillReport(arq, null,d.getCon());
		
		JasperViewer jasperViewer = new JasperViewer(jp);
		
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jasperViewer.setVisible(true);
		
	}

	public void imprimirVendas() throws JRException {
		
		String arq = "RelatorioVendas.jasper";
		DaoImp d = new DaoImp();
		ListaVenda dao = new ListaVenda();
		VendaJRDataSource ds = new VendaJRDataSource(dao.getLista());
		JasperPrint jp = JasperFillManager.fillReport(arq, null,d.getCon());
		
		JasperViewer jasperViewer = new JasperViewer(jp);
		
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jasperViewer.setVisible(true);
		
	}

	public void imprimirClientes() throws JRException {
		
		String arq = "RelatorioClientes.jasper";		
		ListaProdutos dao = new ListaProdutos();
		DaoImp d = new DaoImp();
		ProdutoJRDataSource ds = new ProdutoJRDataSource(dao.getLista());
		JasperPrint jp = JasperFillManager.fillReport(arq, null,d.getCon());
		
		JasperViewer jasperViewer = new JasperViewer(jp);
		
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jasperViewer.setVisible(true);
		
	}
}
