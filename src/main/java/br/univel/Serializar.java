package br.univel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serializar {

	public void SerializarProdutos(Object o, String arquivo) {
		File file = new File(arquivo);
		((ListaProdutos) o).getLista().forEach(e -> {
			try (FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(e);
			} catch (Exception E) {
				E.printStackTrace();
			}
		});
	}

	public void SerializarClientes(Object o, String arquivo) {
		File file = new File(arquivo);
		((ListaClientes) o).getLista().forEach(e -> {
			try (FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(e);
			} catch (Exception E) {
				E.printStackTrace();
			}
		});
	}
	
	public void SerializarVendas(Object o, String arquivo) {
		File file = new File(arquivo);
		((ListaVenda) o).getLista().forEach(e -> {
			try (FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(e);
			} catch (Exception E) {
				E.printStackTrace();
			}
		});
	}

	public void ImportSerialClientes(String arquivo) {
		File file = new File(arquivo);
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			Cliente C = (Cliente) ois.readObject();
			System.out.println(C.getId() + "," + C.getNome() + "," + C.getEndereco() + "," + C.getNumero() + ","
					+ C.getComplemento() + "," + C.getBairro() + "," + C.getCidade() + "," + C.getEstado() + ","
					+ C.getCep() + "," + C.getTelefone() + "," + C.getCelular());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ImportSerialProdutos(String arquivo) {
		File file = new File(arquivo);
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Produto p = (Produto) ois.readObject();
			System.out.println(p.getId() + "," + p.getDescricao() + "," + p.getPreco());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ImportSerialVendas(String arquivo) {
		File file = new File(arquivo);
		try (FileInputStream fis = new FileInputStream(file); 
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			Venda v = (Venda) ois.readObject();
			System.out.println(v.getCodVenda() + "," + v.getValorTotal());

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
