package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import OracleBD.ConnecterBD;

public class NorthPanel4 extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8740808686171197172L;
	private JLabel lblId;
	@SuppressWarnings("rawtypes")
	private static JComboBox cbId;
	private JLabel lblIsbn;
	private JLabel lblTitre;
	private JLabel lblAuteur;
	private JLabel lblTheme;
	private JLabel lblNbExp;
	
	private JLabel lblIsbn2;
	private JLabel lblTitre2;
	private JLabel lblAuteur2;
	private JLabel lblTheme2;
	private static JLabel lblNbExp2;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NorthPanel4()
	{
		this.setBackground(new Color(235,245,240));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(0,150));
		
		createLabels();
		
		Vector<Integer> VectorId = new Vector<Integer>();
		ResultSet result = ConnecterBD.executeSelectQuery("select id_livre from livre");
		try {
			while (result.next())
			{
				VectorId.add(result.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		cbId = new JComboBox(VectorId);
		this.add(cbId);
		cbId.setBounds(100, 17, 100, 25);
		remplirLabels();
		cbId.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					removeLabels();
					remplirLabels();
					TableDisponibles.afficherTous();
					TableEmprunts.afficherTous();
				}
			}
		});

		
		
	}


	private void createLabels() 
	{
		lblId = new JLabel("Identifiant :");
		this.add(lblId);
		lblId.setBounds(20, 20, 100, 20);
		lblId.setFont(new Font("Arial",Font.BOLD,13));
		
		lblIsbn = new JLabel("ISBN :");
		this.add(lblIsbn);
		lblIsbn.setBounds(20, 60, 100, 20);
		lblIsbn.setFont(new Font("Arial",Font.BOLD,13));
		
		lblTitre = new JLabel("Titre :");
		this.add(lblTitre);
		lblTitre.setBounds(20, 100, 100, 20);
		lblTitre.setFont(new Font("Arial",Font.BOLD,13));
		
		lblAuteur = new JLabel("Auteur :");
		this.add(lblAuteur);
		lblAuteur.setBounds(300, 20, 100, 20);
		lblAuteur.setFont(new Font("Arial",Font.BOLD,13));
		
		lblTheme = new JLabel("Theme :");
		this.add(lblTheme);
		lblTheme.setBounds(300, 60, 100, 20);
		lblTheme.setFont(new Font("Arial",Font.BOLD,13));
		
		lblNbExp= new JLabel("Nombre d'exemplaire :");
		this.add(lblNbExp);
		lblNbExp.setBounds(300, 100, 140, 20);
		lblNbExp.setFont(new Font("Arial",Font.BOLD,13));
	}
	
	private void remplirLabels() 
	{
		ResultSet result =ConnecterBD.executeSelectQuery("select* from livre where id_livre = "+cbId.getSelectedItem());
		try {
			while(result.next()) 
			{
				lblIsbn2 = new JLabel(result.getString(2));
				this.add(lblIsbn2);
				lblIsbn2.setBounds(70, 60, 100, 20);
				lblIsbn2.setFont(new Font("Arial",Font.BOLD,13));
				
				lblTitre2 = new JLabel(result.getString(3));
				this.add(lblTitre2);
				lblTitre2.setBounds(70, 100, 100, 20);
				lblTitre2.setFont(new Font("Arial",Font.BOLD,13));
				
				lblAuteur2 = new JLabel(result.getString(4));
				this.add(lblAuteur2);
				lblAuteur2.setBounds(370, 20, 100, 20);
				lblAuteur2.setFont(new Font("Arial",Font.BOLD,13));
						
				lblTheme2 = new JLabel(result.getString(5));
				this.add(lblTheme2);
				lblTheme2.setBounds(370, 60, 100, 20);
				lblTheme2.setFont(new Font("Arial",Font.BOLD,13));
				
				ResultSet result1 = ConnecterBD.executeSelectQuery("select count(*) from exemplaire where id_livre = " +result.getInt(1));
				String ch =null;
				try {
					while(result1.next())
					{
						ch = result1.getString(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				lblNbExp2= new JLabel(ch);
				this.add(lblNbExp2);
				lblNbExp2.setBounds(450, 100, 150, 20);
				lblNbExp2.setFont(new Font("Arial",Font.BOLD,13));

			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	private void removeLabels() 
	{
		remove(lblIsbn2);
		remove(lblTitre2);
		remove(lblAuteur2);
		remove(lblTheme2);
		remove(lblNbExp2);
	}
	
	@SuppressWarnings("rawtypes")
	public static JComboBox getCbId() 
	{
		return cbId;
	}
}