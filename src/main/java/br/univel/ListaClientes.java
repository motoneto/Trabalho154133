package br.univel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clientes")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListaClientes implements Serializable{

	@XmlElement(name = "cliente")
	private List<Cliente> lista = new ArrayList<>();

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
	
	public void addCliente(Cliente c){
		lista.add(c);
	}
	
	public boolean listarClientes(){
		
		if(!lista.isEmpty())
			return true;
		else
			return false;
		
	}
	
}
