package br.univel.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Produto;
import br.univel.Venda;

public class VendaModel extends AbstractTableModel{
	private List<Venda> lista;
	
	public VendaModel(List<Venda> lista){
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int row, int col){
		
		Venda v = lista.get(row);
		
		switch(col){
		
			case 0:
				return v.getCodVenda();
			case 1:
				return v.getValorTotal();				
		}
		
		return null;
		
	}
	@Override
	public String getColumnName(int col){
		
		switch(col){
		
			case 0:
				return "Código";
			case 1:
				return "Valor Total";
		}
		
		return null;
	}

}
