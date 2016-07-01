package br.univel;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestListaProduto {

	@Test
	public void testarListar(){
		
		assertTrue(new ListaProdutos().listarProdutos());
		
	}
	
	@Test
	public void testarListarFalsa(){
		
		assertFalse(new ListaProdutos().listarProdutos());
		
	}
	
}
