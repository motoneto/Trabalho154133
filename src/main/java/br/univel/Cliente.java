package br.univel;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Tabela("CLIENTE")
@XmlRootElement(name = "cliente")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cliente implements Serializable{

	@Coluna(pk=true)
	private int id;
	@Coluna(nome="nome")
	private String nome;
	@Coluna(nome="endereco")
	private String endereco;
	@Coluna(nome="numero")
	private int numero;
	@Coluna(nome="complemento")
	private String complemento;
	@Coluna(nome="bairro")
	private String bairro;
	@Coluna(nome="cidade")
	private String cidade;
	@Coluna(nome="estado")
	private String estado;
	@Coluna(nome="cep")
	private String cep;
	@Coluna(nome="telefone")
	private String telefone;
	@Coluna(nome="celular")
	private String celular;
	
	public Cliente(int id, String nome, String endereco, int numero, String complemento, String bairro, String cidade,
			String estado, String cep, String telefone, String celular) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.celular = celular;
	}
	
	public Cliente(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
