package br.univel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class SqlGen {
	
	protected abstract PreparedStatement CreateTable(Object o , Connection con); 
	protected abstract PreparedStatement DropTable(Object o, Connection con);
	
	protected abstract PreparedStatement InsertValue(Object o, Connection con);
	protected abstract PreparedStatement UpdateValue(Object o, Connection con);
	protected abstract PreparedStatement SelectValues(Object o, Connection con);
	protected abstract PreparedStatement SelectValueById(Object o, Connection con);
	protected abstract PreparedStatement UpdateCliente(Cliente c, Connection con);
	protected abstract PreparedStatement UpdateProduto(Produto p, Connection con);
	
}
