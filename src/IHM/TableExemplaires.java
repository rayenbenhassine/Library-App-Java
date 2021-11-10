package IHM;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;
import net.proteanit.sql.DbUtils;

public class TableExemplaires extends JTable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -35148900545666997L;



	public TableExemplaires()
	{
		super();
		this.setShowGrid(true);
		DefaultTableModel model = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
		int selectedRowIndex = CentrePanel2.getTableLivres().getSelectedRow();
		this.setModel(DbUtils.resultSetToTableModel(ConnecterBD.executeSelectQuery("select id_exemplaire as id, to_char(date_acquisition,'dd/mm/yyyy') as date_acquisition, etat from exemplaire where id_livre = " + model.getValueAt(selectedRowIndex, 0) + " order by id asc")));
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
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
	
	
	
	public static void afficherTous()
	{
		DefaultTableModel model = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
		int selectedRowIndex = CentrePanel2.getTableLivres().getSelectedRow();
		ResultSet result = ConnecterBD.executeSelectQuery("select id_exemplaire as id, to_char(date_acquisition,'dd/mm/yyyy') as date_acquisition, etat from exemplaire where id_livre = " + model.getValueAt(selectedRowIndex, 0) + " order by id asc");
		CentrePanel3.getTableExemplaires().setModel(DbUtils.resultSetToTableModel(result));
	}
	
}
