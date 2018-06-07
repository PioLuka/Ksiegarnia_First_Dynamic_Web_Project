package zad1;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionProvider {
	private static ConnectionProvider connectionProvider;
	// obiekt C3P0 odpowiedzialny za zarzdzanie połczeniami
	private ComboPooledDataSource connectionPool;

	private ConnectionProvider() throws PropertyVetoException {
		connectionPool = new ComboPooledDataSource();
		// podstawowe informacje o bazie danych
		connectionPool.setDriverClass("com.mysql.jdbc.Driver");
		connectionPool.setJdbcUrl("jdbc:mysql://localhost:3306/ksiegarnia");
		connectionPool.setUser("root");
		connectionPool.setPassword("admin");

		// konfiguracja puli połaczeń
		//pocztkowa liczba połaczeń
		connectionPool.setInitialPoolSize(5);
		// min. dostępna liczba podtrzymywanych połczeń
		connectionPool.setMinPoolSize(5);
		// max liczba podtrzymywanych połaczeń
		connectionPool.setMaxPoolSize(20);
		// ilość dodatkowych połczeń, która ma być otworzona, gdy wszystkie s
		// zajęte
		connectionPool.setAcquireIncrement(5);
		// maxymalny czas podtrzymywania połczenia w sec
		connectionPool.setMaxIdleTime(3600);
	}

	public Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}
	
	public void close() {
		connectionPool.close();
	}

	public static ConnectionProvider getInstance() {
		if (connectionProvider == null) {
			try {
				connectionProvider = new ConnectionProvider();
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
		return connectionProvider;
	}
}
