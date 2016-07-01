package br.univel;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TestVenda {

	@Test
	public void testarVenda(){
		
		Produto p = new Produto(1,"Teste",new BigDecimal("80"));
		BigDecimal troco = new RealizarVenda().vender(p,new BigDecimal("100")); 

		BigDecimal esperado = new BigDecimal(20);
		assertEquals(troco,esperado);
		
	}

	@Test
	public void testarVendaFalha(){
		
		Produto p = new Produto(2,"Cachorro",new BigDecimal("50"));
		BigDecimal troco = new RealizarVenda().vender(p,new BigDecimal("100")); 

		BigDecimal esperado = new BigDecimal(20);
		assertEquals(troco,esperado);
		
	}
}
