package br.univel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Tabela("VENDA")
@XmlRootElement(name = "venda")
@XmlAccessorType (XmlAccessType.FIELD)
public class Venda implements Serializable{

	@Coluna(pk=true)
	private int codVenda;
	
	@Coluna(nome="total")
	private BigDecimal valorTotal;
	
	public Venda(){
	}
	
	public Venda(int codVenda, BigDecimal valorTotal) {
		super();
		this.codVenda = codVenda;
		this.valorTotal = valorTotal;
	}
	
	public int getCodVenda() {
		return codVenda;
	}
	
	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
