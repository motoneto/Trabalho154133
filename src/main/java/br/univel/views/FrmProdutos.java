package br.univel.views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import br.univel.Cliente;
import br.univel.DaoImp;
import br.univel.ItemVenda;
import br.univel.Produto;
import br.univel.models.ItemVendaModel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FrmProdutos extends JPanel {
	
	private JFrame janela; 
	private List<Produto> Plist = (List) new DaoImp<>().listarTodosProdutos();
	private JComboBox comboBoxProdutos;
	private JTextField codLabel;
	private JTextField descricaoLabel;
	private JTextField precoLabel;
	
	
	public FrmProdutos() {
		janela = new JFrame("Interação com DataBase");
		janela.setResizable(false);
		janela.setSize(596, 263);;
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setVisible(true);
		janela.setLocationRelativeTo(this);
		janela.getContentPane().setLayout(null);
		
		JLabel lblAlterarProduto = new JLabel("Alterar Produto");
		lblAlterarProduto.setForeground(Color.BLACK);
		lblAlterarProduto.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAlterarProduto.setBounds(26, 11, 275, 52);
		janela.getContentPane().add(lblAlterarProduto);
		
		comboBoxProdutos = new JComboBox();
		comboBoxProdutos.setBounds(26, 99, 546, 20);
		
		Plist.forEach(e -> {
			comboBoxProdutos.addItem(e.getDescricao());
			
		});
		
		comboBoxProdutos.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectProduto();
			}
		});
		
		janela.getContentPane().add(comboBoxProdutos);
		
		JLabel lblSelecioneOProduto = new JLabel("Selecione o Produto Desejado: ");
		lblSelecioneOProduto.setBounds(26, 74, 164, 14);
		janela.getContentPane().add(lblSelecioneOProduto);
		
		JLabel lblcod = new JLabel("Codigo: ");
		lblcod.setBounds(26, 130, 86, 14);
		janela.getContentPane().add(lblcod);
		
		descricaoLabel = new JTextField("");
		descricaoLabel.setBackground(Color.WHITE);
		descricaoLabel.setBounds(101, 155, 471, 14);
		janela.getContentPane().add(descricaoLabel);
		
		JLabel lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setBounds(26, 155, 86, 14);
		janela.getContentPane().add(lblDescricao);
		
		JLabel lblPreco = new JLabel("Preço :");
		lblPreco.setBounds(26, 180, 86, 14);
		janela.getContentPane().add(lblPreco);
		
		codLabel = new JTextField("");
		codLabel.setEditable(false);
		codLabel.setBounds(101, 130, 130, 14);
		janela.getContentPane().add(codLabel);
		
		precoLabel = new JTextField("");
		precoLabel.setBounds(101, 180, 130, 14);
		janela.getContentPane().add(precoLabel);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(454, 195, 118, 32);
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				alterarProduto();
			}
			
		});
		janela.getContentPane().add(btnAlterar);
		
	}
	
	private void alterarProduto() {
		int id = Integer.parseInt(codLabel.getText());
		String descricao = descricaoLabel.getText();
		float val = Float.parseFloat(precoLabel.getText());
		BigDecimal preco = BigDecimal.valueOf(val);
		Produto p = new Produto(id,descricao,preco);
		DaoImp dao = new DaoImp();
		String fim = dao.alterarProduto(p);
		JOptionPane.showMessageDialog(null, fim);
		janela.setVisible(false);
	}

	private void SelectProduto() {
		Plist.forEach(e ->{
			String varName = (String) comboBoxProdutos.getSelectedItem();
			if(e.getDescricao().equalsIgnoreCase(varName)){
				String id = String.valueOf(e.getId());
				codLabel.setText(id);
				descricaoLabel.setText(e.getDescricao());
				String preco = String.valueOf(e.getPreco());
				precoLabel.setText(preco);
			}
		});
		
	}
}
