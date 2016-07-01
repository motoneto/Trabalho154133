package br.univel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializarBackup<T> {

	public void Deserializar(T Object) throws FileNotFoundException{
		
		FileInputStream fis = null;
		ArrayList<T> lista = new ArrayList<T>();
		
		String classe = Object.getClass().getSimpleName();
		System.out.println(classe);
		
		if(classe.equalsIgnoreCase("ListaClientes")){
			fis = new FileInputStream("listaclientes.dat");
		}else if(classe.equalsIgnoreCase("ListaProdutos")){
			fis = new FileInputStream("listaprodutos.dat");
		}else if(classe.equalsIgnoreCase("ListaVenda")){
			fis = new FileInputStream("listavendas.dat");
		}

		try{
			
			 ObjectInputStream ois = new ObjectInputStream(fis);
			 lista = (ArrayList<T>) ois.readObject();
			 ois.close();
			 fis.close();
			 
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException c){
			System.out.println("Classe nao encontrada");
			c.printStackTrace();
		}   	

		
	}

}
