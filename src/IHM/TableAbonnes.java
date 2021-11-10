package IHM;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import OracleBD.ConnecterBD;
import net.proteanit.sql.DbUtils;

public class TableAbonnes extends JTable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6325612996976636637L;

	public TableAbonnes()
	{
		super();
		
		this.setModel(DbUtils.resultSetToTableModel(ConnecterBD.executeSelectQuery("select id_abonne as id, nom_abonne as nom, prenom_abonne as prenom, to_char(date_naissance,'dd/mm/yyyy') as date_de_naissance, email,statut,tel,adresse,login from abonne order by id asc")));
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(159,9,29));
		headerRenderer.setForeground(Color.white);
		this.getTableHeader().setDefaultRenderer(headerRenderer);
		this.getTableHeader().setReorderingAllowed(false);

		this.setShowGrid(true);
		this.setFocusable(false);
		this.setIntercellSpacing(new java.awt.Dimension(0, 0));
		this.setRowHeight(25);
		this.setSelectionBackground(new Color(179,38,57));
		this.setShowVerticalLines(false);
		this.setDefaultEditor(Object.class, null);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	
	public static void afficherTous()
	{
		 ResultSet result = ConnecterBD.executeSelectQuery("select id_abonne as id, nom_abonne as nom, prenom_abonne as prenom, to_char(date_naissance,'dd/mm/yyyy') as date_de_naissance, email,statut,tel,adresse,login from abonne order by id asc");
		 CentrePanel.getTableAbonnes().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParId(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from abonne where id_abonne = " + id);
		CentrePanel.getTableAbonnes().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParPrenom(String prenom)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from abonne where prenom_abonne = " + "'" + prenom + "'");
		CentrePanel.getTableAbonnes().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParNom(String nom)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from abonne where nom_abonne = " + "'" + nom + "'");
		CentrePanel.getTableAbonnes().setModel(DbUtils.resultSetToTableModel(result));
	}

	

	
}

