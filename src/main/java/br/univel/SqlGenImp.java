package br.univel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlGenImp extends SqlGen {

	@Override
	protected PreparedStatement CreateTable(Object obj, Connection con) {
		Class<?> cl = obj.getClass();
		try {

			StringBuilder sb = new StringBuilder();

			String nomeTabela;
			if (cl.isAnnotationPresent(Tabela.class)) {
				Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
				nomeTabela = anotacaoTabela.value();
			} else {
				nomeTabela = cl.getSimpleName().toUpperCase();
			}

			sb.append("CREATE TABLE ").append(nomeTabela).append("(");

			Field[] atributos = cl.getDeclaredFields();

			for (int i = 0; i < atributos.length; i++) {

				Field field = atributos[i];

				String nomeColuna;
				String tipoColuna = null;

				if (field.isAnnotationPresent(Coluna.class)) {
					Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

					if (anotacaoColuna.nome().isEmpty()) {
						nomeColuna = field.getName().toUpperCase();
					} else {
						nomeColuna = anotacaoColuna.nome();
					}

				} else {
					nomeColuna = field.getName().toUpperCase();
				}

				Class<?> tipoParametro = field.getType();

				if (tipoParametro.equals(String.class)) {
					tipoColuna = "VARCHAR(100)";

				} else if (tipoParametro.equals(int.class)) {
					tipoColuna = "INT";
				} else if (tipoParametro.equals(BigDecimal.class)) {
					tipoColuna = "DOUBLE";
				}

				if (i > 0) {
					sb.append(",");
				}

				sb.append(nomeColuna).append(' ').append(tipoColuna);
			}

			sb.append(", PRIMARY KEY( ");

			for (int i = 0, achou = 0; i < atributos.length; i++) {

				Field field = atributos[i];

				if (field.isAnnotationPresent(Coluna.class)) {

					Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

					if (anotacaoColuna.pk()) {

						if (achou > 0) {
							sb.append(", ");
						}

						if (anotacaoColuna.nome().isEmpty()) {
							sb.append(field.getName().toUpperCase());
						} else {
							sb.append(anotacaoColuna.nome());
						}

						achou++;
					}

				}
			}

			sb.append(" )");

			sb.append(" );");
			String strSql = sb.toString();
			System.out.println("SQL GERADO: " + strSql);

			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(strSql);

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

			return ps;
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected PreparedStatement DropTable(Object obj, Connection con) {
		Class<?> cl = obj.getClass();
		StringBuilder sb = new StringBuilder();

		String nomeTabela;

		if (cl.isAnnotationPresent(Tabela.class)) {
			Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
			nomeTabela = anotacaoTabela.value();
		} else {
			nomeTabela = cl.getSimpleName().toUpperCase();
		}

		sb.append("DROP TABLE IF EXISTS ").append(nomeTabela);
		String strSql = sb.toString();
		System.out.println("SQL GERADO: " + strSql);

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(strSql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return ps;

	}

	@Override
	protected PreparedStatement InsertValue(Object o, Connection con) {
		Class<?> cl = o.getClass();
		StringBuilder sb = new StringBuilder();

		String nomeTabela;

		if (cl.isAnnotationPresent(Tabela.class)) {

			Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
			nomeTabela = anotacaoTabela.value();

		} else {
			nomeTabela = cl.getSimpleName().toUpperCase();

		}
		sb.append("INSERT INTO ").append(nomeTabela).append("(");

		Field[] atributos = cl.getDeclaredFields();

		{
			for (int i = 0; i < atributos.length; i++) {

				Field field = atributos[i];

				String nomeColuna;

				if (field.isAnnotationPresent(Coluna.class)) {
					Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

					if (anotacaoColuna.nome().isEmpty()) {
						nomeColuna = field.getName().toUpperCase();
					} else {
						nomeColuna = anotacaoColuna.nome();
					}

				} else {
					nomeColuna = field.getName().toUpperCase();
				}

				if (i > 0) {
					sb.append(", ");
				}

				sb.append(nomeColuna);
			}
		}

		sb.append(")VALUES(");
		for (int i = 0; i < atributos.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append('?');
		}
		sb.append(')');
		String strSql = sb.toString();
		System.out.println("SQL GERADO: " + strSql);

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(strSql);

			for (int i = 0; i < atributos.length; i++) {
				Field field = atributos[i];
				field.setAccessible(true);
				if (field.getType().equals(int.class)) {
					ps.setInt(i + 1, field.getInt(o));
				} else if (field.getType().equals(String.class)) {
					ps.setString(i + 1, String.valueOf(field.get(o)));
				} else if (field.getType().equals(BigDecimal.class)) {
					ps.setString(i + 1, String.valueOf(field.get(o)));
				} else {
					throw new RuntimeException("Tipo não suportado, falta implementar.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return ps;
	}

	@Override
	protected PreparedStatement UpdateValue(Object o, Connection con) {

		Class<?> cl = o.getClass();
		StringBuilder sb = new StringBuilder();

		String nomeTabela;

		if (cl.isAnnotationPresent(Tabela.class)) {

			Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
			nomeTabela = anotacaoTabela.value();

		} else {
			nomeTabela = cl.getSimpleName().toUpperCase();

		}
		sb.append("UPDATE ").append(nomeTabela).append(" SET ");

		Field[] atributos = cl.getDeclaredFields();

		{
			for (int i = 0; i < atributos.length; i++) {

				if (i > 0) {
					Field field = atributos[i];

					String nomeColuna;

					if (field.isAnnotationPresent(Coluna.class)) {
						Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

						if (anotacaoColuna.nome().isEmpty()) {
							nomeColuna = field.getName().toUpperCase();
						} else {
							nomeColuna = anotacaoColuna.nome();
						}

					} else {
						nomeColuna = field.getName().toUpperCase();
					}

					sb.append(nomeColuna).append(" = ");

				}
			}
		}

		sb.append(" WHERE ");

		{
			for (int i = 0; i < atributos.length; i++) {

				if (i == 0) {
					Field field = atributos[i];

					String nomeColuna;
					String valor;

					if (field.isAnnotationPresent(Coluna.class)) {
						Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

						if (anotacaoColuna.nome().isEmpty()) {
							nomeColuna = field.getName().toUpperCase();
						} else {
							nomeColuna = anotacaoColuna.nome();

						}

					} else {
						nomeColuna = field.getName().toUpperCase();
					}

					sb.append(nomeColuna).append(" = ").append("1").append(" , ");

					if (i > 0) {
						sb.append(", ");
					}

				}
			}
		}

		String strSql = sb.toString();
		System.out.println("SQL GERADO: " + strSql);

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(strSql);

			for (int i = 0; i < atributos.length; i++) {
				Field field = atributos[i];
				field.setAccessible(true);
				if (field.getType().equals(int.class)) {
					ps.setInt(i + 1, field.getInt(o));
				} else if (field.getType().equals(String.class)) {
					ps.setString(i + 1, String.valueOf(field.get(o)));
				} else if (field.getType().equals(BigDecimal.class)) {
					ps.setString(i + 1, String.valueOf(field.get(o)));
				} else {
					throw new RuntimeException("Tipo não suportado, falta implementar.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return ps;

	}

	@Override
	protected PreparedStatement SelectValues(Object o, Connection con) {

		Class<?> cl = o.getClass();
		StringBuilder sb = new StringBuilder();
		String nomeTabela;
		if (cl.isAnnotationPresent(Tabela.class)) {

			Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
			nomeTabela = anotacaoTabela.value();

		} else {
			nomeTabela = cl.getSimpleName().toUpperCase();

		}
		sb.append("SELECT * FROM ").append(nomeTabela);
		String strSql = sb.toString();
		System.out.println("SQL GERADO: " + strSql);
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(strSql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return ps;
	}

	@Override
	protected PreparedStatement SelectValueById(Object o, Connection con) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	protected PreparedStatement UpdateCliente(Cliente c, Connection con) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("UPDATE CLIENTE SET"
					+ " NOME = '"+c.getNome()
					+ "', ENDERECO = '"+c.getEndereco()
					+ "', NUMERO = "+c.getNumero()
					+ ",COMPLEMENTO = '"+c.getComplemento()
					+ "', BAIRRO = '"+c.getBairro()
					+ "', CIDADE = '"+c.getCidade()
					+ "', ESTADO = '"+c.getEstado()
					+ "', CEP = '"+c.getCep()
					+ "', TELEFONE = '"+c.getTelefone()
					+ "', CELULAR = '"+c.getCelular()
					+ "' WHERE ID = "+c.getId());
			
			String strSql = sb.toString();
			System.out.println("SQL GERADO: " + strSql);

			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(strSql);

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

			return ps;
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected PreparedStatement UpdateProduto(Produto p, Connection con) {
		StringBuilder sb = new StringBuilder();
		String f = p.getPreco().toString();
		try {
			sb.append("UPDATE PRODUTO SET"
					+ " DESCRICAO = '"+p.getDescricao()
					+ "', PRECO = "+f
					+ " WHERE ID = "+p.getId());
			
			String strSql = sb.toString();
			System.out.println("SQL GERADO: " + strSql);

			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(strSql);

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

			return ps;
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

}
