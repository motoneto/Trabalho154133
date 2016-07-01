package br.univel.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;

import br.univel.Cliente;
import br.univel.DaoImp;
import br.univel.ItemVenda;
import br.univel.Produto;
import br.univel.Venda;
import br.univel.models.ItemVendaModel;
import br.univel.models.ProdutoModel;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;

public class FrmCaixa extends JPanel {
	private JTextField QtdField;
	private JTextField PrecoUnicoField;
	private JTextField TotalField;
	private JTextField TotalVendaField;
	private JTextField TrocoField;
	private JTextField ValorPagoField;
	private JComboBox comboBox;
	private JComboBox comboBox2;
	private JFrame janela;
	private int CodVenda;
	private float valortotal;
	private List<Venda> Vlist = new ArrayList<>();
	private List<ItemVenda> Ilist = new ArrayList<>();
	private List<Produto> Plist = (List) new DaoImp<>().listarTodosProdutos();
	private List<Cliente> Clist = (List) new DaoImp<>().listarTodosClientes();
	private JTable table;
	/**
	 * Create the panel.
	 */
	public FrmCaixa() {
		janela = new JFrame("CAIXA");
		janela.setResizable(false);
		janela.setSize(909, 600);
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setVisible(true);
		janela.setLocationRelativeTo(this);
		janela.getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(10, 109, 129, 14);
		janela.getContentPane().add(lblCliente);
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(10, 134, 584, 36);
		comboBox2.addItem("Escolher Cliente");
		Clist.forEach(e -> {
			comboBox2.addItem(e.getNome());
			
		});
		
		janela.getContentPane().add(comboBox2);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(10, 179, 129, 14);
		janela.getContentPane().add(lblProduto);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 204, 584, 36);
		comboBox.addItem("Escolher Produto");
		Plist.forEach(e -> {
			comboBox.addItem(e.getDescricao());
		});
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarItem();
			}
			
		});
		janela.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Quantidade:");
		lblNewLabel.setBounds(10, 21, 100, 14);
		janela.getContentPane().add(lblNewLabel);
		
		QtdField = new JTextField();
		QtdField.setBounds(10, 46, 86, 34);
		janela.getContentPane().add(QtdField);
		QtdField.setColumns(10);
		
		JLabel lblPreo = new JLabel("Preço Unico:");
		lblPreo.setBounds(121, 21, 46, 14);
		janela.getContentPane().add(lblPreo);
		
		PrecoUnicoField = new JTextField();
		PrecoUnicoField.setEditable(false);
		PrecoUnicoField.setBounds(118, 46, 170, 34);
		janela.getContentPane().add(PrecoUnicoField);
		PrecoUnicoField.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(307, 21, 46, 14);
		janela.getContentPane().add(lblTotal);
		
		TotalField = new JTextField();
		TotalField.setEditable(false);
		TotalField.setColumns(10);
		TotalField.setBounds(307, 46, 170, 34);
		janela.getContentPane().add(TotalField);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(505, 46, 89, 34);
		btnAdicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarItemLista();
				
//				DaoImp dao = new DaoImp();
//				dao.create(new Venda());
//				int teste = 0;
//				int codvenda = 0;
//				BigDecimal vInsert;
//				for(int i = 0;i<20;i++){
//					teste += i;
//					codvenda++;
//					vInsert = BigDecimal.valueOf(teste);
//					dao.salvar(new Venda(codvenda,vInsert));					
//				}
				
			}
			
		});
		janela.getContentPane().add(btnAdicionar);
		
		JLabel lblNewLabel_1 = new JLabel("Carrinho de Compras:");
		lblNewLabel_1.setBounds(10, 251, 210, 14);
		janela.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(615, 52, 250, 320);
		janela.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalVenda = new JLabel("Total Venda");
		lblTotalVenda.setBounds(10, 11, 139, 14);
		panel.add(lblTotalVenda);
		
		TotalVendaField = new JTextField();
		TotalVendaField.setEditable(false);
		TotalVendaField.setBounds(10, 36, 230, 32);
		panel.add(TotalVendaField);
		TotalVendaField.setColumns(10);
		
		JLabel lblValorPago = new JLabel("Valor Pago");
		lblValorPago.setBounds(10, 79, 230, 14);
		panel.add(lblValorPago);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setBounds(10, 188, 57, 14);
		panel.add(lblTroco);
		
		TrocoField = new JTextField();
		TrocoField.setEditable(false);
		TrocoField.setColumns(10);
		TrocoField.setBounds(10, 213, 230, 32);
		panel.add(TrocoField);
		
		ValorPagoField = new JTextField();
		ValorPagoField.setColumns(10);
		ValorPagoField.setBounds(10, 104, 230, 32);
		panel.add(ValorPagoField);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Venda v;
				DaoImp dao = new DaoImp();
				
				int totalv = dao.listarTodasVendas().size();
				if(totalv != 0){
					v = new Venda(totalv+1,new BigDecimal(TotalVendaField.getText()));
				}else{
					dao.create(new Venda());
					v = new Venda(1,new BigDecimal(TotalVendaField.getText()));				
				}
				dao.salvar(v);
				Vlist.add(v);
				fecharVenda();
				
			}
		});
		btnNewButton.setBounds(10, 257, 112, 23);
		panel.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(128, 257, 112, 23);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fecharVenda();
			}
			
		});
		panel.add(btnCancelar);
		
		JButton btnCalcularTroco = new JButton("Calcular Troco");
		btnCalcularTroco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float troco = 0;
				float vTotal = Float.parseFloat(TotalVendaField.getText());
				float vPago = Float.parseFloat(ValorPagoField.getText());
				if(vPago >= vTotal){
					troco = vPago - vTotal; 
				}
				TrocoField.setText(String.valueOf(troco));
			}
		});
		btnCalcularTroco.setBounds(10, 154, 230, 23);
		panel.add(btnCalcularTroco);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 276, 584, 284);
		janela.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(0, 0, 584, 284);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Código", "Descrição", "Preço Unitario", "Qtd", "Valor Total"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(1).setPreferredWidth(290);
		table.getColumnModel().getColumn(3).setPreferredWidth(44);
		
//		table.setModel(model);
		panel_1.add(table);
	}
	
	protected void adicionarItem(){
		valortotal = 0;
		Plist.forEach(e ->{
			String varName = (String) comboBox.getSelectedItem();
			if(e.getDescricao().equalsIgnoreCase(varName)){
				String preco = e.getPreco().toString();
				PrecoUnicoField.setText(preco);
				String qtd = QtdField.getText();
				Float pr = Float.parseFloat(preco);
				Float qt = Float.parseFloat(qtd);
				float total = (qt*pr);
				String totalf = String.valueOf(total);
				TotalField.setText(totalf);
				ItemVenda it = new ItemVenda(e.getId(),e.getDescricao(),e.getPreco(), qt, total);
				Ilist.add(it);
				ItemVendaModel model = new ItemVendaModel(Ilist);
				table.setModel(model);
				Ilist.forEach(i -> {
					valortotal += i.getTotal();
					String Vtotal = String.valueOf(valortotal);
					TotalVendaField.setText(Vtotal);
				});
				
			}
		});
	}
	
	protected void adicionarItemLista(){
		float totalteste = 0;
		BigDecimal novovalor;
		BigDecimal valoratual,valorsomado;
		String valorantigo = TotalVendaField.getText();
		Ilist.forEach(e-> {
//			totalteste += 
		});
		if(valorantigo.isEmpty()){
			TotalVendaField.setText(TotalField.getText());
		}else{
			novovalor = new BigDecimal(valorantigo);
			TotalVendaField.setText(novovalor.toString());
		}
//		Vlist.add(e);
		
	}
	
	protected void fecharVenda(){
		janela.setVisible(false);
	}
}
