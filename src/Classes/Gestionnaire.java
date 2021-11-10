package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import OracleBD.ConnecterBD;

public class Gestionnaire
{
	private String login;
	private String mdp;
	private String nom_gestionnaire;
	private String prenom_gestionnaire;
	
	public Gestionnaire(String x, String y, String z, String t)
	{
		this.login = x;
		this.mdp = y;
		this.nom_gestionnaire = z;
		this.prenom_gestionnaire = t;
	}
	
	public static String getNom(String login)
	{
		String log = null;
		try 
		{
			ConnecterBD con = new ConnecterBD();
			Statement statement = con.obtenirconnexion().createStatement();
			ResultSet result = statement.executeQuery("select nom_gestionnaire from gestionnaire where login = '" + login + "'");
			while (result.next())
			{
				return result.getString("nom_gestionnaire");
			}	
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return log;
	}
	
	
	
	public static String getPrenom(String login)
	{
		String log = null;
		try 
		{
			ConnecterBD con = new ConnecterBD();
			Statement statement = con.obtenirconnexion().createStatement();
			ResultSet result = statement.executeQuery("select prenom_gestionnaire from gestionnaire where login = '" + login + "'");
			while (result.next())
			{
				return result.getString("prenom_gestionnaire");
			}	
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return log;
	}
	
	public static boolean exists(String login, String mdp)
	{
		boolean ok = false;
		try 
		{
			ConnecterBD con = new ConnecterBD();
			Statement statement = con.obtenirconnexion().createStatement();
			ResultSet result = statement.executeQuery("select * from gestionnaire");
			while (result.next() && ok == false)
			{
				if (result.getString("login").equals(login) && result.getString("mdp").equals(mdp))
				{
					ok =  true;
					System.out.println(result.getString("login") + " " + result.getString("mdp"));
				}
		
			}	
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}



	public String getLogin() 
	{
		return login;
	}

	public String getMdp()
	{
		return mdp;
	}

	public String getNom_gestionnaire()
	{
		return nom_gestionnaire;
	}



	public String getPrenom_gestionnaire() {
		return prenom_gestionnaire;
	}
	
	
	
	
}
