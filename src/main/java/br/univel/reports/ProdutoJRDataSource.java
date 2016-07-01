package br.univel.reports;

import java.util.Iterator;
import java.util.List;

import br.univel.Produto;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class ProdutoJRDataSource implements JRDataSource {

	private List<Produto> lista;
	private Produto selecionado;
	private Iterator<Produto> iterator;

	public ProdutoJRDataSource(List<Produto> lista) {
		this.lista = lista;
		this.iterator = lista.iterator();
	}

	public ProdutoJRDataSource() {

	}

	@Override
	public boolean next() throws JRException {
		if (iterator.hasNext()){
			selecionado = iterator.next();
			return true;
		}
		return false;
	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {

		if("id".equals(arg0.getName())){
			return selecionado.getId();
		}else if("nome".equals(arg0.getName())){
			return selecionado.getDescricao();
		}else if(arg0.getName().equals("preco")){
			return selecionado.getPreco();
		}
		return "Undefined!";
	}

}
