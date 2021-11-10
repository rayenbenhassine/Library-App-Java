package IHM;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import OracleBD.ConnecterBD;
import net.proteanit.sql.DbUtils;

public class TableEmprunts extends JTable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3452958614601293951L;



	public TableEmprunts()
	{
		super();
		this.setModel(DbUtils.resultSetToTableModel(ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt,to_char(date_retour,'dd/mm/yyyy') as date_retour,statut from emprunter where statut = 'en cours' and id_livre = " + NorthPanel4.getCbId().getSelectedItem() + " order by id_emprunter")));
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
		this.setAutoResizeMode(AUTO_RESIZE_OFF);

	}
	
	
	
	public static void afficherTous()
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt,to_char(date_retour,'dd/mm/yyyy') as date_retour,statut from emprunter where statut = 'en cours' and id_livre = " + NorthPanel4.getCbId().getSelectedItem() + " order by id_emprunter");
		EmpruntsPanel.getTableEmpurunts().setModel(DbUtils.resultSetToTableModel(result));
	}



	public static void afficherTousEmprunts() 
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter , id_abonne,id_exemplaire,id_livre,to_char(date_emprunt,'dd/mm/yyyy') as date_emprunt,to_char(date_retour,'dd/mm/yyyy') as date_retour,statut from emprunter where statut = 'en cours' order by id_emprunter");
		EmpruntsPanel.getTableEmpurunts().setModel(DbUtils.resultSetToTableModel(result));
	}
	
}