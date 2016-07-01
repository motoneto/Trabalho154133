package br.univel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

public class XML {

	public boolean ExportarXML(Object p, String str) throws IOException{
		
		Marshaller marshaller = null;

		StringWriter out = new StringWriter();
		JAXBContext context = null;
		
		try{
			context = JAXBContext.newInstance(p.getClass());
			marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			marshaller.marshal(p, new StreamResult(out));
			
			String xml = out.toString();
			FileWriter fw = new FileWriter(str);
			fw.write(xml);
			System.out.println(xml);
			fw.close();
			
			return true;
			
		}catch(PropertyException e){
			e.printStackTrace();
		}catch(JAXBException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public List<Produto> importarProduto(String arquivo) {
		List<Produto> list = new ArrayList<Produto>();
			try {
				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				String xml = sb.toString();
				br.close();
				fr.close();
				StringReader in = new StringReader(xml);
				JAXBContext context = JAXBContext.newInstance(ListaProdutos.class);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				ListaProdutos Prd = (ListaProdutos) unmarshaller.unmarshal(in);
				Prd.getLista().forEach(e -> {
					Produto p = new Produto(e.getId(),e.getDescricao(),e.getPreco());
					list.add(p);
				});
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public List<Cliente> importarCliente(String arquivo) {
		List<Cliente> list = new ArrayList<Cliente>();
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String xml = sb.toString();
			br.close();
			fr.close();
			StringReader in = new StringReader(xml);
			JAXBContext context = JAXBContext.newInstance(ListaClientes.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ListaClientes Prd = (ListaClientes) unmarshaller.unmarshal(in);
			Prd.getLista().forEach(e -> {
				Cliente c = new Cliente(e.getId(),e.getNome(), e.getEndereco(),e.getNumero(),e.getComplemento(),e.getBairro(),e.getCidade()
				,e.getEstado(),e.getCep(),e.getTelefone(),e.getCelular());
				list.add(c);
			});
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Venda> importarVendas(String arquivo) {
		List<Venda> list = new ArrayList<Venda>();
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String xml = sb.toString();
			br.close();
			fr.close();
			StringReader in = new StringReader(xml);
			JAXBContext context = JAXBContext.newInstance(ListaVenda.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ListaVenda Prd = (ListaVenda) unmarshaller.unmarshal(in);
			Prd.getLista().forEach(e -> {
				Venda p = new Venda(e.getCodVenda(),e.getValorTotal());
				list.add(p);
			});
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	return list;
	}
}


