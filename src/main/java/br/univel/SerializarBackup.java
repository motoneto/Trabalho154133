package br.univel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializarBackup<T> {
	
	public void serializar(T Object) {
		
		File file = null;
		String classe = Object.getClass().getCanonicalName();
		
		if(classe.equalsIgnoreCase("br.univeL.Cliente")){
			
			file = new File("listaclientes.dat");
			
		}else if(classe.equalsIgnoreCase("Produto")){
			
			file = new File("listaprodutos.dat");
					
		}else if(classe.equalsIgnoreCase("Venda")){
			
			file = new File("listavendas.dat");
		} else {
			throw new RuntimeException("O Mateus esqueceu de considerar um dos arquivos:" + classe);
		}
		
		try (FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos)){//A atribuição das variaveis dos recursos dentro dos () define que este sera fechado automaticamente

			oos.writeObject((T) Object);//Envia os atributos do objeto 'cloriginal' para o 'oos' e este grava no 'fos'
			
		}catch(FileNotFoundException e){//Irá mostrar uma excessão caso o arquivo não seja encontrado
			
			e.printStackTrace();
			
		}catch(IOException e){//Irá mostrar uma excessão caso ocorra alguma objeção na compilação do código
			
			e.printStackTrace();
			
		}
	}
	
}
