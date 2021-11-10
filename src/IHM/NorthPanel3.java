package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;

public class NorthPanel3 extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1163902502113852186L;
	private JLabel lblId;
	private JLabel lblIsbn;
	private JLabel lblTitre;
	private JLabel lblAuteur;
	private JLabel lblTheme;
	private JLabel lblNbExp;
	
	private JLabel lblId2;
	private JLabel lblIsbn2;
	private JLabel lblTitre2;
	private JLabel lblAuteur2;
	private JLabel lblTheme2;
	private static JLabel lblNbExp2;
	
	public NorthPanel3()
	{
		this.setBackground(new Color(217,236,236));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(0,150));
		
		DefaultTableModel model = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
		int selectedRowIndex = CentrePanel2.getTableLivres().getSelectedRow();
		
		lblId = new JLabel("Identifiant :");
		this.add(lblId);
		lblId.setBounds(20, 20, 100, 20);
		lblId.setFont(new Font("Arial",Font.BOLD,13));
		
		lblId2 = new JLabel(model.getValueAt(selectedRowIndex, 0).toString());
		this.add(lblId2);
		lblId2.setBounds(90, 20, 100, 20);
		lblId2.setFont(new Font("Arial",Font.BOLD,13));

		
		lblIsbn = new JLabel("ISBN :");
		this.add(lblIsbn);
		lblIsbn.setBounds(20, 60, 100, 20);
		lblIsbn.setFont(new Font("Arial",Font.BOLD,13));
		
		lblIsbn2 = new JLabel(model.getValueAt(selectedRowIndex, 1).toString());
		this.add(lblIsbn2);
		lblIsbn2.setBounds(70, 60, 100, 20);
		lblIsbn2.setFont(new Font("Arial",Font.BOLD,13));
		
		
		lblTitre = new JLabel("Titre :");
		this.add(lblTitre);
		lblTitre.setBounds(20, 100, 100, 20);
		lblTitre.setFont(new Font("Arial",Font.BOLD,13));
		
		lblTitre2 = new JLabel(model.getValueAt(selectedRowIndex, 2).toString());
		this.add(lblTitre2);
		lblTitre2.setBounds(70, 100, 100, 20);
		lblTitre2.setFont(new Font("Arial",Font.BOLD,13));
		
		lblAuteur = new JLabel("Auteur :");
		this.add(lblAuteur);
		lblAuteur.setBounds(300, 20, 100, 20);
		lblAuteur.setFont(new Font("Arial",Font.BOLD,13));
		
		lblAuteur2 = new JLabel(model.getValueAt(selectedRowIndex, 3).toString());
		this.add(lblAuteur2);
		lblAuteur2.setBounds(370, 20, 100, 20);
		lblAuteur2.setFont(new Font("Arial",Font.BOLD,13));
		
		lblTheme = new JLabel("Theme :");
		this.add(lblTheme);
		lblTheme.setBounds(300, 60, 100, 20);
		lblTheme.setFont(new Font("Arial",Font.BOLD,13));
		
		lblTheme2 = new JLabel(model.getValueAt(selectedRowIndex, 5).toString());
		this.add(lblTheme2);
		lblTheme2.setBounds(370, 60, 100, 20);
		lblTheme2.setFont(new Font("Arial",Font.BOLD,13));
		
		lblNbExp= new JLabel("Nombre d'exemplaire :");
		this.add(lblNbExp);
		lblNbExp.setBounds(300, 100, 140, 20);
		lblNbExp.setFont(new Font("Arial",Font.BOLD,13));
		
		ResultSet result = ConnecterBD.executeSelectQuery("select count(*) from exemplaire where id_livre = " + model.getValueAt(selectedRowIndex, 0));
		String ch =null;
		try {
			while(result.next())
			{
				ch = result.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblNbExp2= new JLabel(ch);
		this.add(lblNbExp2);
		lblNbExp2.setBounds(450, 100, 150, 20);
		lblNbExp2.setFont(new Font("Arial",Font.BOLD,13));
		
		
	}
	
	public static void refresh()
	{
		DefaultTableModel model = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
		int selectedRowIndex = CentrePanel2.getTableLivres().getSelectedRow();
		ResultSet result = ConnecterBD.executeSelectQuery("select count(*) from exemplaire where id_livre = " + model.getValueAt(selectedRowIndex, 0));
		String ch =null;
		try {
			while(result.next())
			{
				ch = result.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RightPanel3.getNorthPanel3().remove(lblNbExp2);
		lblNbExp2= new JLabel(ch);
		RightPanel3.getNorthPanel3().add(lblNbExp2);
		lblNbExp2.setBounds(450, 100, 150, 20);
		lblNbExp2.setFont(new Font("Arial",Font.BOLD,13));
	}
}