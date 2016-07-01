package br.univel;

import static org.junit.Assert.*;

import org.junit.Test;

public class LerArqTest {

	@Test
	public void testLeitura(){
		
		assertTrue(new LerArquivo().VerificarArquivo("produtos.txt"));
		
	}
	
	@Test
	public void testLeituraFalha(){
		
		assertTrue(new LerArquivo().VerificarArquivo("teste.xml"));
		
	}
	
	@Test
	public void testLeituraFalhaComFalse(){
		
		assertFalse(new LerArquivo().VerificarArquivo("teste.xml"));
		
	}
	
}
