package br.univel.reports;

import java.util.Iterator;
import java.util.List;

import br.univel.Produto;
import br.univel.Venda;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class VendaJRDataSource implements JRDataSource {

	private List<Venda> lista;
	private Venda selecionado;
	private Iterator<Venda> iterator;

	public VendaJRDataSource(List<Venda> lista) {
		this.lista = lista;
		this.iterator = lista.iterator();
	}

	public VendaJRDataSource() {

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
			return selecionado.getCodVenda();
		}else if("total".equals(arg0.getName())){
			return selecionado.getValorTotal();
		}
		
		return "Undefined!";
	}

}
