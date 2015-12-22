/**
 * 
 */
package br.net.ops.kamino.gateway.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import br.net.ops.kamino.gateway.Gateway;
import br.net.ops.kamino.gateway.mysql.connection.KaminoConfig;
import br.net.ops.kamino.gateway.mysql.connection.ConnectionManager;

/**
 * @author cedulio
 *
 */
public class MySQLDAO extends Gateway {

	private KaminoConfig connectionConfig;

	public MySQLDAO(KaminoConfig connectionConfig) {
		setConnectionConfig(connectionConfig);
	}

	public KaminoConfig getConnectionConfig() {
		return connectionConfig;
	}

	private void setConnectionConfig(KaminoConfig connectionConfig) {
		this.connectionConfig = connectionConfig;
	}

	protected Connection getConnection() throws SQLException {
		return ConnectionManager.getInstance(getConnectionConfig())
				.getConnection();
	}

}
