/**
 * 
 */
package br.net.ops.kamino.gateway.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cedulio
 *
 */
public class ConnectionManager {

	private static ConnectionManager INSTANCE = null;
	private Connection connection;

	private ConnectionManager(KaminoConfig connectionConfig)
			throws SQLException {

		String stringConnection = String.format("jdbc:mysql://%s:%s/%s",
				connectionConfig.getHost(), connectionConfig.getPort(),
				connectionConfig.getSchema());

		connection = DriverManager.getConnection(stringConnection,
				connectionConfig.getUser(), connectionConfig.getPass());
	}

	public static ConnectionManager getInstance(
			KaminoConfig connectionConfig) throws SQLException {

		if (INSTANCE == null) {
			INSTANCE = new ConnectionManager(connectionConfig);
		}

		return INSTANCE;
	}

	public Connection getConnection() {
		return connection;
	}

}
