package IHM;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import OracleBD.ConnecterBD;
import net.proteanit.sql.DbUtils;

public class TableDisponibles extends JTable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5055723828823850121L;



	public TableDisponibles()
	{
		super();
		this.setModel(DbUtils.resultSetToTableModel(ConnecterBD.executeSelectQuery("select id_exemplaire, etat,to_char(date_acquisition,'dd/mm/yyyy') as date_acquisition from exemplaire where id_livre = " + NorthPanel4.getCbId().getSelectedItem() + " and id_exemplaire not in (select id_exemplaire from emprunter where statut = 'en cours' and id_livre = " + NorthPanel4.getCbId().getSelectedItem() + ") order by id_exemplaire")));
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
		ResultSet result = ConnecterBD.executeSelectQuery("select id_exemplaire, etat,to_char(date_acquisition,'dd/mm/yyyy') as date_acquisition from exemplaire where id_livre = " + NorthPanel4.getCbId().getSelectedItem() + " and id_exemplaire not in (select id_exemplaire from emprunter where statut = 'en cours' and id_livre = " + NorthPanel4.getCbId().getSelectedItem() + ") order by id_exemplaire");
		DisponiblesPanel.getTableDisponibles().setModel(DbUtils.resultSetToTableModel(result));
	}
	
}