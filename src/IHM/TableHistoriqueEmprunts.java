package IHM;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import OracleBD.ConnecterBD;
import net.proteanit.sql.DbUtils;

public class TableHistoriqueEmprunts extends JTable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3269989220039320958L;
	public TableHistoriqueEmprunts()
	{
		super();
		this.setModel(DbUtils.resultSetToTableModel(ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt ,to_char(date_retour,'dd/mm/yyyy') as date_retour ,statut from emprunter where statut = 'rendu' order by id_emprunter")));
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(36,72,54));
		headerRenderer.setForeground(Color.white);
		this.getTableHeader().setDefaultRenderer(headerRenderer);
		this.getTableHeader().setReorderingAllowed(false);
		
		this.setShowGrid(true);
		this.setFocusable(false);
		this.setIntercellSpacing(new java.awt.Dimension(0, 0));
		this.setRowHeight(25);
		this.setSelectionBackground(new Color(63,123,93));
		this.setShowVerticalLines(false);
		this.setDefaultEditor(Object.class, null);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
	
	
	
	public static void afficherTous()
	{
		 ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt ,to_char(date_retour,'dd/mm/yyyy') as date_retour ,statut from emprunter where statut = 'rendu' order by id_emprunter");
		 CentrePanel5.getTableHistoriqueEmprunts().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParIdEmprunt(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt ,to_char(date_retour,'dd/mm/yyyy') as date_retour ,statut from emprunter where statut = 'rendu' and id_emprunter = " + id + " order by id_emprunter");
		CentrePanel5.getTableHistoriqueEmprunts().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParIdLivre(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt ,to_char(date_retour,'dd/mm/yyyy') as date_retour ,statut from emprunter where statut = 'rendu' and id_emprunter = " + id + "  order by id_emprunter");
		CentrePanel5.getTableHistoriqueEmprunts().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParIdExemplaire(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt ,to_char(date_retour,'dd/mm/yyyy') as date_retour ,statut from emprunter where statut = 'rendu' and id_emprunter = " + id + "  order by id_emprunter");
		CentrePanel5.getTableHistoriqueEmprunts().setModel(DbUtils.resultSetToTableModel(result));
	}
	public static void afficherParIdAbonne(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt ,to_char(date_retour,'dd/mm/yyyy') as date_retour ,statut from emprunter where statut = 'rendu' and id_abonne = " + id + "  order by id_emprunter");
		CentrePanel5.getTableHistoriqueEmprunts().setModel(DbUtils.resultSetToTableModel(result));
	}

	

	
}
