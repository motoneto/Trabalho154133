package br.univel.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.ItemVenda;

public class ItemVendaModel extends AbstractTableModel{
		private List<ItemVenda> lista;
		
		public ItemVendaModel(List<ItemVenda> lista){
			this.lista = lista;
		}
		
		@Override
		public int getColumnCount(){
			return 5;
		}
		
		@Override
		public int getRowCount(){
			return lista.size();
		}

		@Override
		public String getColumnName(int col){
			
			switch (col) {
				case 0:
					return "CODIGO";
				case 1:
					return "DESCRIÇÃO";
				case 2:
					return "PREÇO";
				case 3:
					return "QUANTIDADE";
				case 4:
					return "TOTAL";
				default:
					return "erro";
					
			}
			
		}
		
		@Override
		public Object getValueAt(int row, int col){
			
			ItemVenda c = lista.get(row);
			
			switch (col) {
				case 0:
					return c.getCodigo();
				case 1:
					return c.getDescricao();
				case 2:
					return c.getPreco();
				case 3:
					return c.getQuantidade();
				case 4:
					return c.getTotal();
				default:
					return "erro";
					
			}
			
		}
		
		public ItemVenda getClienteNaLinha(int index){
			return lista.get(index);
		}
		
		public void removerCliente(ItemVenda c){
			int idx = this.lista.indexOf(c);
			this.lista.remove(c);
			super.fireTableRowsDeleted(idx, idx);
		}
		
		public void adicionarCliente(ItemVenda c){
			this.lista.add(c);
			super.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
		}
		
	}
