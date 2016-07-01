package br.univel.reports;

import java.util.List;

import br.univel.Cliente;
import br.univel.ListaClientes;
import net.sf.jasperreports.engine.JRDataSource;

public class ClienteDsFactory {
//desenhar o relatorio.
	public static JRDataSource criar(){
		ListaClientes dao = new ListaClientes();
		List<Cliente> lista = dao.getLista();
		
		ClienteJRDataSource ds = new ClienteJRDataSource(lista);
		
		return ds;
	}
	
}