package br.univel.reports;

import java.util.List;

import br.univel.ListaProdutos;
import br.univel.ListaVenda;
import br.univel.Produto;
import br.univel.Venda;
import net.sf.jasperreports.engine.JRDataSource;

public class VendaDsFactory {
//desenhar o relatorio.
	public static JRDataSource criar(){
		ListaVenda dao = new ListaVenda();
		List<Venda> lista = dao.getLista();
		
		VendaJRDataSource ds = new VendaJRDataSource(lista);
		
		return ds;
	}
	
}
