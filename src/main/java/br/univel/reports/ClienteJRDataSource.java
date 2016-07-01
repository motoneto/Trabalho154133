package br.univel.reports;

import java.util.Iterator;
import java.util.List;

import br.univel.Cliente;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class ClienteJRDataSource implements JRDataSource {

	private List<Cliente> lista;
	private Cliente selecionado;
	private Iterator<Cliente> iterator;

	public ClienteJRDataSource(List<Cliente> lista) {
		this.lista = lista;
		this.iterator = lista.iterator();
	}

	public ClienteJRDataSource() {

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
			return selecionado.getNome();
		}else if("endereco".equals(arg0.getName())){
			return selecionado.getEndereco();
		}else if("numero".equals(arg0.getName())){
			return selecionado.getNumero();
		}else if("complemento".equals(arg0.getName())){
			return selecionado.getComplemento();
		}else if("bairro".equals(arg0.getName())){
			return selecionado.getBairro();
		}else if("cidade".equals(arg0.getName())){
			return selecionado.getCidade();
		}else if("estado".equals(arg0.getName())){
			return selecionado.getEstado();
		}else if("cep".equals(arg0.getName())){
			return selecionado.getCep();
		}else if("telefone".equals(arg0.getName())){
			return selecionado.getTelefone();
		}else if("celular".equals(arg0.getName())){
			return selecionado.getCelular();
		}
		return "Undefined!";
	}

}
