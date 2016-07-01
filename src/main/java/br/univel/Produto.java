package br.univel;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.*;

@Tabela("PRODUTO")
@XmlRootElement(name = "produto")
@XmlAccessorType (XmlAccessType.FIELD)
public class Produto implements Serializable{
	
	
	@Coluna(pk=true)
	private int id;
	
	@Coluna(nome="descricao")
	private String descricao;
	
	@Coluna(nome="preco")
	private BigDecimal preco;
	
	public Produto() {

    }
	
	public Produto(int id, String descricao, BigDecimal preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
}
