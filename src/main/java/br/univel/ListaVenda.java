package br.univel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vendas")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListaVenda {

	@XmlElement(name = "venda")
	private List<Venda> lista = new ArrayList<>();

	public ListaVenda(){
		
	}
	
	public ListaVenda(List<Venda> lista) {
		super();
		this.lista = lista;
	}

	public List<Venda> getLista() {
		return lista;
	}

	public void setLista(List<Venda> lista) {
		this.lista = lista;
	}
	
	public void addProduto(Venda p){
		lista.add(p);
	}
	
	public boolean listarVendas(){
		
		if(!lista.isEmpty())
			return true;
		else
			return false;
		
	}
	
}
