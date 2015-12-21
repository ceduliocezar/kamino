/**
 * 
 */
package br.net.ops.kamino.gateway.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import br.net.ops.kamino.gateway.Gateway;
import br.net.ops.kamino.gateway.mysql.connection.ConnectionConfig;
import br.net.ops.kamino.gateway.mysql.connection.ConnectionManager;

/**
 * @author cedulio
 *
 */
public class MySQLDAO extends Gateway {

	private ConnectionConfig connectionConfig;

	public MySQLDAO(ConnectionConfig connectionConfig) {
		setConnectionConfig(connectionConfig);
	}

	public ConnectionConfig getConnectionConfig() {
		return connectionConfig;
	}

	private void setConnectionConfig(ConnectionConfig connectionConfig) {
		this.connectionConfig = connectionConfig;
	}

	protected Connection getConnection() throws SQLException {
		return ConnectionManager.getInstance(getConnectionConfig())
				.getConnection();
	}

}
