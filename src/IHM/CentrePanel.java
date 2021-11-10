package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class CentrePanel extends JPanel
{

	private static final long serialVersionUID = 1767155385655794373L;
	private static TableAbonnes tableAbonnes;
	
	public CentrePanel()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		tableAbonnes = new TableAbonnes();
		this.add(tableAbonnes,BorderLayout.CENTER);
		this.add(tableAbonnes.getTableHeader(),BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(tableAbonnes);
		this.add(scrollPane);
		
	}

	public static TableAbonnes getTableAbonnes()
	{
		return tableAbonnes;
	}


	

}

