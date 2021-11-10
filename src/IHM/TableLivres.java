package IHM;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import OracleBD.ConnecterBD;
import net.proteanit.sql.DbUtils;

public class TableLivres extends JTable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7180779864884776201L;

	public TableLivres()
	{
		super();
		this.setModel(DbUtils.resultSetToTableModel(ConnecterBD.executeSelectQuery("select id_livre as id, isbn, titre, auteur, nb_pages, theme, maison_edition from livre order by id asc")));
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(35,106,106));
		headerRenderer.setForeground(Color.white);
		this.getTableHeader().setDefaultRenderer(headerRenderer);
		this.getTableHeader().setReorderingAllowed(false);
		
		this.setShowGrid(true);
		this.setFocusable(false);
		this.setIntercellSpacing(new java.awt.Dimension(0, 0));
		this.setRowHeight(25);
		this.setSelectionBackground(new Color(41,125,125));
		this.setShowVerticalLines(false);
		this.setDefaultEditor(Object.class, null);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
	
	
	
	public static void afficherTous()
	{
		 ResultSet result = ConnecterBD.executeSelectQuery("select id_livre as id, isbn, titre, auteur, nb_pages, theme, maison_edition from livre order by id asc");
		 CentrePanel2.getTableLivres().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParId(String id)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from livre where id_livre = " + id);
		CentrePanel2.getTableLivres().setModel(DbUtils.resultSetToTableModel(result));
	}
	
	public static void afficherParISBN(String isbn)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from livre where isbn = " + isbn);
		CentrePanel2.getTableLivres().setModel(DbUtils.resultSetToTableModel(result));
	}



	public static void afficherParTitre(String titre) 
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from livre where titre = '" + titre+ "'");
		CentrePanel2.getTableLivres().setModel(DbUtils.resultSetToTableModel(result));
	}


	public static void afficherParAuteur(String auteur) 
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from livre where auteur = '" + auteur+ "'");
		CentrePanel2.getTableLivres().setModel(DbUtils.resultSetToTableModel(result));
	}

	public static void afficherParTheme(String theme) 
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select * from livre where theme = '" + theme+ "'");
		CentrePanel2.getTableLivres().setModel(DbUtils.resultSetToTableModel(result));
	}
}

