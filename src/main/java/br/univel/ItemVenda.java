package br.univel;

import java.math.BigDecimal;

public class ItemVenda {
	
	private int codigo;
	private String Descricao;
	private BigDecimal preco;
	private float quantidade;
	private float total;
	
	
	
	public ItemVenda(int codigo, String descricao, BigDecimal preco, Float qt, float total) {
		super();
		this.codigo = codigo;
		Descricao = descricao;
		this.preco = preco;
		this.quantidade = qt;
		this.total = total;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	

}
