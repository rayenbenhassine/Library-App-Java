package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import OracleBD.ConnecterBD;

public class Emprunt 
{
	private int idEmprunt;
	private int idAbonne;
	private int idExemplaire;
	private int idLivre;
	private String dateEmprunt;
	private String dateRetour;
	private String statut;

	
	public Emprunt(int idEmprunt, int idAbonne, int idExemplaire, int idLivre, String dateEmprunt, String dateRetour,String statut) 
	{
		this.idEmprunt = idEmprunt;
		this.idAbonne = idAbonne;
		this.idExemplaire = idExemplaire;
		this.idLivre = idLivre;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.statut = statut;
	}
	
	public void ajouterEmprunt()
	{
		ConnecterBD.executeQuery("insert into emprunter values (" + this.idEmprunt +  "," + this.idAbonne +"," + this.idExemplaire +","+ this.idLivre + ",'"+ this.dateEmprunt +"','"+this.dateRetour+"','"+this.statut+"')");
	}

	
	public static boolean RechercheParIdEmprunt(String idEmprunt)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select id_emprunter from emprunter");
		Integer d = 0;
		try 
	    {
	       d = Integer.parseInt(idEmprunt);

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
				if (result.getInt("id_emprunter") == d)
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
	
	public static boolean RechercheParIdLivre(String idLivre)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select id_livre from emprunter");
		Integer d = 0;
		try 
	    {
	       d = Integer.parseInt(idLivre);

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
				if (result.getInt("id_livre") == d)
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
	
	public static boolean RechercheParIdExemplaire(String idExemplaire)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select id_exemplaire from emprunter");
		Integer d = 0;
		try 
	    {
	       d = Integer.parseInt(idExemplaire);

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
				if (result.getInt("id_exemplaire") == d)
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
	
	public static boolean RechercheParIdAbonne(String idAbonne)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select id_abonne from emprunter");
		Integer d = 0;
		try 
	    {
	       d = Integer.parseInt(idAbonne);

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

}
