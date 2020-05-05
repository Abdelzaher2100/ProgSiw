package persistence;

import persistence.DAOFactory;
import persistence.DataSource;
import persistence.UtenteDaoJDBC;
import persistence.dao.*;

public class PostgresDAOFactory extends DAOFactory {

	private static DataSource dataSource;
	private static PostgresDAOFactory factory;

	// --------------------------------------------

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
		//remoto
		//dataSource = new DataSource("jdbc:postgresql://packy.db.elephantsql.com:5432/ttywdcne", "ttywdcne", "WM0RwbB8eHKhElY7Vg8Vk7j6VjXbL8YH");
			
		//locale
		dataSource=new DataSource("jdbc:mysql://localhost:3306/webcomputing?serverTimezone=UTC","root","");
		
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}
	

	public static PostgresDAOFactory getInstance(){
		if (factory == null){
			factory = new PostgresDAOFactory();
		}
		return factory;
	}
	// --------------------------------------------

	@Override
	public UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}

	


}
