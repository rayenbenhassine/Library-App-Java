package Classes;

import OracleBD.ConnecterBD;

public class Exemplaire 
{
	private int idExemplaire;
	private String DateAcquisition;
	private int idLivre;
	private String etat;

	public Exemplaire(int idExemplaire,String DateAcquisition,int idLivre,String etat)
	{
		this.idExemplaire = idExemplaire;
		this.DateAcquisition = DateAcquisition;
		this.idLivre = idLivre;
		this.etat = etat;
	}
	
	public void ajouterExemplaire()
	{
		ConnecterBD.executeQuery("insert into exemplaire values (" + this.idExemplaire +  ",'" + this.DateAcquisition +"'," + this.idLivre +",'"+ this.etat + "')");
	}

}
