package OracleBD;

import java.sql.*;


public class ConnecterBD
{
	private Connection connection_var;
	
	public ConnecterBD()
	{
		charger_driver();
		try
		{
			connection_var = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","admin","projetjava"); //connecting to the database
			System.out.println("Connection Successful");
		} 
		catch (SQLException e) 
		{
			System.out.println("Some problem in connection");
			e.printStackTrace();
		}
	}
	
	private void charger_driver() 
	{
	    try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	    }
	    catch(ClassNotFoundException e)
	    {
	        System.err.println(e);
	    }
	}
    
	public Connection obtenirconnexion()
	{
		return connection_var;
	}
	
	
	
	public static void executeQuery(String sql)
	{
		try 
		{
			ConnecterBD con = new ConnecterBD();
			Statement statement = con.obtenirconnexion().createStatement();
			statement.execute(sql);

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static ResultSet executeSelectQuery(String sql)
	{
		try 
		{
			ConnecterBD con = new ConnecterBD();
			Statement statement = con.obtenirconnexion().createStatement();
			ResultSet result = statement.executeQuery(sql);
			return result;

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;

	}
	

}
