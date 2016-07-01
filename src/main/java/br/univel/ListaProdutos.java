package br.univel;

import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "produtos")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListaProdutos {

	@XmlElement(name = "produto")
	private List<Produto> lista = new ArrayList<>();
	public ListaProdutos(){
		
	}
	
	public ListaProdutos(List<Produto> lista) {
		super();
		this.lista = lista;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public void addProduto(Produto p){
		lista.add(p);
	}
	
	public boolean listarProdutos(){
		
		if(!lista.isEmpty())
			return true;
		else
			return false;
		
	}
}
