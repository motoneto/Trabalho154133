package br.univel;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class TestInsercaoTabela {
	
	@Test
	public void testeInsert() throws SQLException{
		assertTrue(new DaoImp().TabelaExiste());
	}
}
