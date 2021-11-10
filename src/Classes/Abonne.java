package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import OracleBD.ConnecterBD;

public class Abonne 
{
	private int id_abonne;
	private String nom_abonne;
	private String prenom_abonne;
	private String date_naissance;
	private String email;
	private String statut;
	private long tel;
	private String adresse;
	private String login;
	
	
	public Abonne(int id_abonne, String nom_abonne, String prenom_abonne, String date_naissance, String email,
			String statut, long tel, String adresse, String login) 
	{
		this.id_abonne = id_abonne;
		this.nom_abonne = nom_abonne;
		this.prenom_abonne = prenom_abonne;
		this.date_naissance = date_naissance;
		this.email = email;
		this.statut = statut;
		this.tel = tel;
		this.adresse = adresse;
		this.login = login;
	}
	
	public void ajouterAbonne()
	{
		try 
		{
			ConnecterBD con = new ConnecterBD();
			Statement statement = con.obtenirconnexion().createStatement();
			statement.execute("insert into abonne values (" + this.id_abonne + ",'" + this.nom_abonne + "','" + this.prenom_abonne +"','" + this.date_naissance +"','"+ this.email + "','" + this.statut + "'," + this.tel + ",'" + this.adresse + "','" + this.login + "')");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static boolean RechercheParId(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select id_abonne from abonne");
		Integer d = 0;
		try 
	    {
	       d = Integer.parseInt(id);

	    } 
	    catch (NumberFormatException nfe) 
	    {
	    	nfe.printStackTrace();
	    }
	    
		try
		{
			boolean ok = false; 
			while (result.next() && ok == false)
			{
				if (result.getInt("id_abonne") == d)
				{
					ok = true;
					return ok;
				}
			}
			return ok;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;

		}

	}
	

	public static boolean RechercheParPrenom(String prenom)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select prenom_abonne from abonne order by id_abonne");
		try
		{
			boolean ok = false; 
			while (result.next() && ok == false)
			{
				if (result.getString("prenom_abonne").equals(prenom))
				{
					ok = true;
					return ok;
				}
			}
			return ok;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;

		}
	}
	
	public static boolean RechercheParNom(String nom)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select nom_abonne from abonne order by id_abonne");
		try
		{
			boolean ok = false; 
			while (result.next() && ok == false)
			{
				if (result.getString("nom_abonne").equals(nom))
				{
					ok = true;
					return ok;
				}
			}
			return ok;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;

		}

	}
	
}
	
	
