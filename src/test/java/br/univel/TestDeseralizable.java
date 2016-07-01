package br.univel;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestDeseralizable {

	
	@Test
	public void TestDeserializar() throws FileNotFoundException{
		new DeserializarBackup().Deserializar(new ListaClientes());
	}
	
}
