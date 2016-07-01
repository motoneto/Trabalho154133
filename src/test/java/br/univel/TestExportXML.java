package br.univel;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class TestExportXML {

	
	@Test
	public void	testExportacaoLista() throws IOException{
		
		ListaProdutos produtos = new ListaProdutos();
		
		produtos.setLista(new ArrayList<Produto>());
		
		Produto a = new Produto(1,"Teste A",new BigDecimal(3));
		Produto b = new Produto(2,"Teste B",new BigDecimal(4));
		
		produtos.getLista().add(a);
		produtos.getLista().add(b);
		
		assertTrue(new XML().ExportarXML(produtos, "listaprodutos.xml"));
		
	}

}
