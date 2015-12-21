/**
 * 
 */
package br.net.ops.kamino.gateway;

import java.util.List;

import br.net.ops.kamino.entity.Despesa;

/**
 * @author cedulio
 *
 */
public interface DespesasDAO {

	public void save(Despesa despesa) throws Exception;

	public void saveAll(List<Despesa> despesas) throws Exception;

}
