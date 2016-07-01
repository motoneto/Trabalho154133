package br.univel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoImp<T, K> implements Dao<T, K> {

	PreparedStatement ps = null;
	ListaProdutos lista;
	Connection con = null;

	public Connection getCon() {
		if (con == null){
			try {
				con = abrirConexao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	static Connection abrirConexao() throws SQLException {
		String url = "jdbc:h2:~/MauricioToneto";
		String user = "sa";
		String pass = "sa";
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}

	@Override
	public void salvar(T t) {
		SqlGen s = new SqlGenImp();
		Connection con = null;
		try {
			con = abrirConexao();
			PreparedStatement psInsert = s.InsertValue(t, con);
			psInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(T t) {
		SqlGen s = new SqlGenImp();
		Connection con = null;
		try {
			con = abrirConexao();
			PreparedStatement psInsert = s.UpdateValue(t, con);
			psInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T t) {
		SqlGen s = new SqlGenImp();
		Connection con = null;
		PreparedStatement psInsert = null;
		try {
			con = abrirConexao();
			psInsert = s.DropTable(t, con);
			psInsert.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodosClientes() {
		StringBuilder sb = new StringBuilder();
		SqlGen s = new SqlGenImp();
		Connection con = null;
		List<Cliente> array = new ArrayList<Cliente>();
		List<String> rt = new ArrayList<String>();
		Cliente t = new Cliente(0, null, null, 0, null, null, null, null, null, null, null);
		try {
			con = abrirConexao();
			ResultSet result = null;
			PreparedStatement psListar = s.SelectValues(t, con);
			
			try {
					
				result = psListar.executeQuery();				
				while (result.next()) {
					int id = result.getInt(1);
					String nome = result.getString("nome");
					String endereco = result.getString("endereco");
					int numero = result.getInt("numero");
					String complemento = result.getString("complemento");
					String bairro = result.getString("bairro");
					String cidade = result.getString("cidade");
					String estado = result.getString("estado");
					String cep = result.getString("cep");
					String telefone = result.getString("telefone");
					String celular = result.getString("celular");
					array.add(new Cliente(id,nome,endereco,numero,complemento,bairro,cidade,
					estado,cep,telefone,celular));
				}
			}finally{
				if (ps != null) ps.close();
				if (result != null) result.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List<T>) array;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<T> listarTodosProdutos() {
		StringBuilder sb = new StringBuilder();
		SqlGen s = new SqlGenImp();
		Connection con = null;
		List<Produto> array = new ArrayList<Produto>();
		List<String> rt = new ArrayList<String>();
		Produto p = new Produto(0,null,null);
		try {
			
			con = abrirConexao();
			ResultSet result = null;
			PreparedStatement psListar = s.SelectValues(p, con);
			
			try {
					
				result = psListar.executeQuery();				
				while (result.next()) {
					int id = result.getInt(1);
					String descricao = result.getString("descricao");
					BigDecimal preco = result.getBigDecimal("preco");
					array.add(new Produto(id, descricao, preco));
				}
			}finally{
				if (ps != null) ps.close();
				if (result != null) result.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List<T>) array;
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<T> listarTodasVendas() {
		StringBuilder sb = new StringBuilder();
		SqlGen s = new SqlGenImp();
		Connection con = null;
		List<Venda> array = new ArrayList<Venda>();
		List<String> rt = new ArrayList<String>();
		Venda v = new Venda(0,null);
		try {
			
			con = abrirConexao();
			ResultSet result = null;
			PreparedStatement psListar = s.SelectValues(v, con);
			
			try {
					
				result = psListar.executeQuery();				
				while (result.next()) {
					int id = result.getInt(1);
					BigDecimal preco = result.getBigDecimal("total");
					array.add(new Venda(id,preco));
				}
			}finally{
				if (ps != null) ps.close();
				if (result != null) result.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List<T>) array;
	}
	
	@Override
	public T buscar(K k) {
		return null;
	
	}

	@Override
	public void create(T t) {
		SqlGen s = new SqlGenImp();
		Connection con = null;
		PreparedStatement psCreate = null;
		try {
			con = abrirConexao();
			psCreate = s.CreateTable(t, con);
			psCreate.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(K k) {
		SqlGen s = new SqlGenImp();
		Connection con = null;
		try {
			con = abrirConexao();
			PreparedStatement psInsert = s.UpdateValue(k, con);
			psInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean TabelaExiste() throws SQLException {

		ps = new SqlGenImp().SelectValues(lista, con);
		ps.executeQuery();

		if (ps != null)
			return true;
		else
			return false;

	}



	@Override
	public String alterarCliente(Cliente c) {
		SqlGen s = new SqlGenImp();
		Connection con = null;
		try {
			con = abrirConexao();
			PreparedStatement psInsert = s.UpdateCliente(c, con);
			psInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Não foi possivel alterar o Cliente";
		}
		return "Cliente alterado com sucesso";
	}

	@Override
	public String alterarProduto(Produto p) {
		SqlGen s = new SqlGenImp();
		Connection con = null;
		try {
			con = abrirConexao();
			PreparedStatement psInsert = s.UpdateProduto(p, con);
			psInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Não foi possivel alterar o Produto";
		}
		return "Produto alterado com sucesso";
	}
}
