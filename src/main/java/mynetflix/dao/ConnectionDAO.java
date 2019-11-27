package mynetflix.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDAO {
	
	private DataSource dataSource;
	
	public ConnectionDAO() {
		try {
			Context envContext = InitialContext.doLookup("java:/comp/env");
			this.dataSource = (DataSource) envContext.lookup("myNetflix");
		} catch(NamingException e) {
			throw new ErreurDAOException("");
		}
	}
	
	protected Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
