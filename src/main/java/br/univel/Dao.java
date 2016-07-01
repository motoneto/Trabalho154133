package br.univel;

import java.math.BigDecimal;
import java.util.List;

public interface Dao<T, K> {

	public void salvar(T t);

	public T buscar(K k);

	public void atualizar(T t);

	public void excluir(K k);

	public List<T> listarTodosProdutos();

	public List<T> listarTodosClientes();
	
	public void create(T t);
	
	public void delete(T t);

	public List<T> listarTodasVendas();
	public String alterarCliente(Cliente c);
	public String alterarProduto(Produto p);
	
}
