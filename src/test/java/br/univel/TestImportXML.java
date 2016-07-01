package br.univel;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class TestImportXML {

	@Test
	public void	testImportacaoLista() throws IOException, JAXBException{
		
		ListaProdutos produtos = new ListaProdutos();
		
		produtos.setLista(new ArrayList<Produto>());
		
		new XML().importarProduto("produtos.xml");
		
	}
	
}
