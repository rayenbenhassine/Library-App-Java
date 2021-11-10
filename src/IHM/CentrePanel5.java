package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class CentrePanel5 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8773723092174234687L;
	private static TableHistoriqueEmprunts tableHistoriqueEmprunts;
	
	public CentrePanel5()
	{
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		tableHistoriqueEmprunts = new TableHistoriqueEmprunts();
		this.add(tableHistoriqueEmprunts.getTableHeader(),BorderLayout.NORTH);
		this.add(tableHistoriqueEmprunts,BorderLayout.CENTER);

	}

	public static TableHistoriqueEmprunts getTableHistoriqueEmprunts()
	{
		return tableHistoriqueEmprunts;
	}


	

}

