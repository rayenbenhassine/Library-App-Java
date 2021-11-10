package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import OracleBD.ConnecterBD;

public class Livre 
{
	private int id_livre;
	private long isbn;
	private String titre;
	private String auteur;
	private int nb_pages;
	private String theme;
	private String maison_edition;
	
	

	
	public Livre(int id_livre, long isbn, String titre, String auteur, int nb_pages, String theme,
			String maison_edition) 
	{
		this.id_livre = id_livre;
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
		this.nb_pages = nb_pages;
		this.theme = theme;
		this.maison_edition = maison_edition;
	}

	public void ajouterLivre()
	{
		ConnecterBD.executeQuery("insert into livre values (" + this.id_livre + "," + this.isbn + ",'" + this.titre +"','" + this.auteur + "'," + this.nb_pages + ",'" + this.theme + "','" + this.maison_edition + "')");
		ConnecterBD.executeQuery("create sequence seq_id_exemplaire_" + this.id_livre + " start with 1");
	}
	
	public static boolean RechercheParId(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select id_livre from livre");
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
	
	public static boolean RechercheParISBN(String isbn)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select isbn from livre");
		Integer d = 0;
		try 
	    {
	       d = Integer.parseInt(isbn);

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
				if (result.getInt("isbn") == d)
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
	
	public static boolean RechercheParTitre(String titre)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select titre from livre order by id_livre");
		try
		{

			boolean ok = false; 
			while (result.next() && ok == false)
			{

				if (result.getString("titre").equals(titre))
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
	
	public static boolean RechercheParAuteur(String auteur)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select auteur from livre order by id_livre");
		try
		{

			boolean ok = false; 
			while (result.next() && ok == false)
			{

				if (result.getString("auteur").equals(auteur))
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
	
	public static boolean RechercheParTheme(String theme)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("Select theme from livre order by id_livre");
		try
		{

			boolean ok = false; 
			while (result.next() && ok == false)
			{

				if (result.getString("theme").equals(theme))
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


	
	public long getIsbn() {
		return isbn;
	}
}
	
	
