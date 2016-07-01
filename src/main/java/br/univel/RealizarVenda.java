package br.univel;

import java.math.BigDecimal;
import java.util.List;

public class RealizarVenda {

	private List<Produto> lista;
	private BigDecimal valor;
	private BigDecimal troco;
	private BigDecimal entrada;
	
	public RealizarVenda(){
		
	}
	
	public RealizarVenda(List<Produto> lista, BigDecimal valor, BigDecimal troco, BigDecimal entrada) {
		super();
		this.lista = lista;
		this.valor = valor;
		this.troco = troco;
		this.entrada = entrada;
	}
	public List<Produto> getLista() {
		return lista;
	}
	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getTroco() {
		return troco;
	}
	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}
	public BigDecimal getEntrada() {
		return entrada;
	}
	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;
	}
	
	public BigDecimal vender(Produto p, BigDecimal entrada){
		
		BigDecimal troco = entrada;
		BigDecimal valor = p.getPreco();
		
		return troco.subtract(valor);
	}
	
	
}
