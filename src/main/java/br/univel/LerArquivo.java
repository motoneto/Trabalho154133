package br.univel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {
	
	public boolean VerificarArquivo(String str){
	
		File f = new File(str);
		if(f.exists() && !f.isDirectory()){
			return true;
		}
		return false;
	}
	
	public List<String> lerArquivo(String str){
		
		ArrayList<String> lista = new ArrayList<>();
		
		if(VerificarArquivo(str)){
			
			try(FileReader fr = new FileReader(new File(str));
					BufferedReader br = new BufferedReader(fr)){
				
				String linha = null;
				while((linha = br.readLine()) != null){
					lista.add(linha);
				}
				
				System.out.println("teste");


			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			
			System.out.println("Arquivo não existente!");
			
		}

		return lista;
	}
	
}
