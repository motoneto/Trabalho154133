package br.univel.views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import br.univel.Cliente;
import br.univel.DaoImp;
import br.univel.ItemVenda;
import br.univel.models.ItemVendaModel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FrmClientes extends JPanel {
	
	private JFrame janela; 
	private List<Cliente> Clist = (List) new DaoImp<>().listarTodosClientes();
	private JComboBox comboBoxClientes;
	private JTextField nomeLabel;
	private JTextField codLabel;
	private JTextField enderecoLabel;
	private JTextField numeroLabel;
	private JTextField compLabel;
	private JTextField bairroLabel;
	private JTextField cidadeLabel;
	private JTextField estadoLabel;
	private JTextField cepLabel;
	private JTextField telefoneLabel;
	private JTextField celularLabel;
	
	
	public FrmClientes() {
		janela = new JFrame("Interação com DataBase");
		janela.setResizable(false);
		janela.setSize(685, 350);;
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setVisible(true);
		janela.setLocationRelativeTo(this);
		janela.getContentPane().setLayout(null);
		
		JLabel lblAlterarCliente = new JLabel("Alterar Cliente");
		lblAlterarCliente.setForeground(Color.BLACK);
		lblAlterarCliente.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAlterarCliente.setBounds(26, 11, 239, 52);
		janela.getContentPane().add(lblAlterarCliente);
		
		comboBoxClientes = new JComboBox();
		comboBoxClientes.setBounds(26, 99, 626, 20);
		Clist.forEach(e -> {
			comboBoxClientes.addItem(e.getNome());
			
		});
		comboBoxClientes.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectCliente();
			}
		});
		janela.getContentPane().add(comboBoxClientes);
		
		JLabel lblSelecioneOCliente = new JLabel("Selecione o Cliente Desejado: ");
		lblSelecioneOCliente.setBounds(26, 74, 145, 14);
		janela.getContentPane().add(lblSelecioneOCliente);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(26, 154, 46, 14);
		janela.getContentPane().add(lblNome);
				
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(26, 229, 46, 14);
		janela.getContentPane().add(lblCodigo);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(26, 179, 65, 14);
		janela.getContentPane().add(lblEndereo);
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setBounds(255, 179, 57, 14);
		janela.getContentPane().add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(431, 179, 86, 14);
		janela.getContentPane().add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(26, 204, 46, 14);
		janela.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade: ");
		lblCidade.setBounds(255, 204, 46, 14);
		janela.getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(431, 204, 72, 14);
		janela.getContentPane().add(lblEstado);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(255, 229, 46, 14);
		janela.getContentPane().add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(26, 254, 86, 14);
		janela.getContentPane().add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(255, 254, 46, 14);
		janela.getContentPane().add(lblCelular);
		
		codLabel = new JTextField("");
		codLabel.setEditable(false);
		codLabel.setBounds(101, 229, 144, 14);
		janela.getContentPane().add(codLabel);
		
		nomeLabel = new JTextField("");
		nomeLabel.setBackground(Color.WHITE);
		nomeLabel.setBounds(101, 154, 551, 14);
		janela.getContentPane().add(nomeLabel);
		
		enderecoLabel = new JTextField("");
		enderecoLabel.setBounds(101, 179, 144, 14);
		janela.getContentPane().add(enderecoLabel);
		
		numeroLabel = new JTextField("");
		numeroLabel.setBounds(311, 179, 110, 14);
		janela.getContentPane().add(numeroLabel);
		
		compLabel = new JTextField("");
		compLabel.setBounds(522, 179, 130, 14);
		janela.getContentPane().add(compLabel);
		
		bairroLabel = new JTextField("");
		bairroLabel.setBounds(101, 204, 144, 14);
		janela.getContentPane().add(bairroLabel);
		
		cidadeLabel = new JTextField("");
		cidadeLabel.setBounds(311, 204, 110, 14);
		janela.getContentPane().add(cidadeLabel);
		
		estadoLabel = new JTextField("");
		estadoLabel.setBounds(522, 204, 130, 14);
		janela.getContentPane().add(estadoLabel);
		
		cepLabel = new JTextField("");
		cepLabel.setBounds(311, 229, 110, 14);
		janela.getContentPane().add(cepLabel);
		
		telefoneLabel = new JTextField("");
		telefoneLabel.setBounds(101, 254, 144, 14);
		janela.getContentPane().add(telefoneLabel);
		
		celularLabel = new JTextField("");
		celularLabel.setBounds(311, 254, 110, 14);
		janela.getContentPane().add(celularLabel);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(534, 278, 118, 32);
		btnAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alterarCliente();
			}
		});
		janela.getContentPane().add(btnAlterar);
	}
	private void alterarCliente() {
		int id = Integer.parseInt(codLabel.getText());
		String nome = nomeLabel.getText();
		String endereco = enderecoLabel.getText();
		int numero = Integer.parseInt(numeroLabel.getText());
		String complemento = compLabel.getText();
		String bairro = bairroLabel.getText();
		String cidade = cidadeLabel.getText();
		String estado = estadoLabel.getText();
		String cep = cepLabel.getText();
		String telefone = telefoneLabel.getText();
		String celular = celularLabel.getText();
		Cliente c = new Cliente(id,nome,endereco,numero,complemento,bairro,cidade,estado,
				cep,telefone,celular);
		DaoImp dao = new DaoImp();
		String fim = dao.alterarCliente(c);
		JOptionPane.showMessageDialog(null, fim);
		janela.setVisible(false);
	}
	private void SelectCliente() {
		Clist.forEach(e ->{
			String varName = (String) comboBoxClientes.getSelectedItem();
			if(e.getNome().equalsIgnoreCase(varName)){
				nomeLabel.setText(e.getNome());
				String id = String.valueOf(e.getId());
				codLabel.setText(id);
				enderecoLabel.setText(e.getEndereco());
				String numero = String.valueOf(e.getNumero());
				numeroLabel.setText(numero);
				compLabel.setText(e.getComplemento());
				bairroLabel.setText(e.getBairro());
				cidadeLabel.setText(e.getCidade());
				estadoLabel.setText(e.getEstado());
				cepLabel.setText(e.getCep());
				telefoneLabel.setText(e.getTelefone());
				celularLabel.setText(e.getCelular());
			}
		});
		
	}
}
