package br.univel;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.*;

public class TestConexaoBD {

	private Connection con;

	@Test
	public void testConexao() throws SQLException, ClassNotFoundException{
		
		con = new DaoImp().abrirConexao();
		
		assertNotNull(con);
	
	}
	
	@After
	public void fecharConexao() throws SQLException{
		con.close();
	}
	
}
