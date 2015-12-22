/**
 * 
 */
package br.net.ops.kamino.gateway.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.net.ops.kamino.entity.Despesa;
import br.net.ops.kamino.gateway.DespesasDAO;
import br.net.ops.kamino.gateway.mysql.connection.KaminoConfig;

/**
 * @author cedulio
 *
 */
public class DespesaDAOMySQL extends MySQLDAO implements DespesasDAO {

	public DespesaDAOMySQL(KaminoConfig connectionConfig) {
		super(connectionConfig);
	}

	@Override
	public void save(Despesa despesa) throws Exception {

		StringBuilder insert = new StringBuilder();

		insert.append("	INSERT INTO despesa	");
		insert.append("	(	");
		insert.append("	ano,	");
		insert.append("	mes,	");
		insert.append("	senador,	");
		insert.append("	tipo_despesa,	");
		insert.append("	cnpj_cpf,	");
		insert.append("	fornecedor,	");
		insert.append("	documento,	");
		insert.append("	data,	");
		insert.append("	detalhamento,	");
		insert.append("	valor_reembolsado,	");
		insert.append("	ops_data_processamento,	");
		insert.append(" )");
		insert.append("	VALUES(	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	NOW())	");

		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement(insert.toString());

		try {
			int index = 0;

			ps.setInt(++index, despesa.getAno());
			ps.setInt(++index, despesa.getMes());
			ps.setString(++index, despesa.getSenador());
			ps.setString(++index, despesa.getTipoDespesa());
			ps.setString(++index, despesa.getCnpjCpf());
			ps.setString(++index, despesa.getFornecedor());
			ps.setString(++index, despesa.getDocumento());
			ps.setDate(++index, new java.sql.Date(despesa.getData().getTime()));
			ps.setString(++index, despesa.getDetalhamento());
			ps.setDouble(++index, despesa.getValor());

			ps.execute();
		} finally {
			ps.close();
		}

	}

	@Override
	public void saveAll(List<Despesa> despesas) throws Exception {

		StringBuilder insert = new StringBuilder();

		insert.append("	INSERT INTO despesa	");
		insert.append("	(	");
		insert.append("	ano,	");
		insert.append("	mes,	");
		insert.append("	senador,	");
		insert.append("	tipo_despesa,	");
		insert.append("	cnpj_cpf,	");
		insert.append("	fornecedor,	");
		insert.append("	documento,	");
		insert.append("	data,	");
		insert.append("	detalhamento,	");
		insert.append("	valor_reembolsado,	");
		insert.append("	ops_data_processamento	");
		insert.append(" )");
		insert.append("	VALUES(	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	?,	");
		insert.append("	NOW())	");

		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement(insert.toString());

		for (Despesa despesa : despesas) {

			int index = 0;

			ps.setInt(++index, despesa.getAno());
			ps.setInt(++index, despesa.getMes());
			ps.setString(++index, despesa.getSenador());
			ps.setString(++index, despesa.getTipoDespesa());
			ps.setString(++index, despesa.getCnpjCpf());
			ps.setString(++index, despesa.getFornecedor());
			ps.setString(++index, despesa.getDocumento());
			ps.setDate(++index, new java.sql.Date(despesa.getData().getTime()));
			ps.setString(++index, despesa.getDetalhamento());
			ps.setDouble(++index, despesa.getValor());

			ps.addBatch();

		}

		try {
			ps.executeBatch();
		} finally {
			ps.close();
		}
	}

}
