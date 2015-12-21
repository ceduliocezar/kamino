/**
 * 
 */
package br.net.ops.kamino.business;

import java.util.List;

import br.net.ops.kamino.entity.Despesa;
import br.net.ops.kamino.gateway.DespesasDAO;
import br.net.ops.kamino.gateway.mysql.DespesaDAOMySQL;
import br.net.ops.kamino.gateway.mysql.connection.ConnectionConfig;

/**
 * @author cedulio
 *
 */
public class SalvarDespesas extends UseCase {

	private DespesasDAO despesasDAO;

	public SalvarDespesas(ConnectionConfig configConnectionConfig) {
		this.despesasDAO = new DespesaDAOMySQL(configConnectionConfig);
	}

	public void exec(List<Despesa> despesas) throws Exception {
		System.out.println("Iniciando processo para salvar registros.");
		despesasDAO.saveAll(despesas);
		System.out.println("Finalizou processo.");
	}

}
