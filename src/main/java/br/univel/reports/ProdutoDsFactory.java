package br.univel.reports;

import java.util.List;

import br.univel.ListaProdutos;
import br.univel.Produto;
import net.sf.jasperreports.engine.JRDataSource;

public class ProdutoDsFactory {
//desenhar o relatorio.
	public static JRDataSource criar(){
		ListaProdutos dao = new ListaProdutos();
		List<Produto> lista = dao.getLista();
		
		ProdutoJRDataSource ds = new ProdutoJRDataSource(lista);
		
		return ds;
	}
	
}
