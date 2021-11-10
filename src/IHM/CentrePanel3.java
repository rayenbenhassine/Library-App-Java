package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class CentrePanel3 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3847457194292766258L;
	private static TableExemplaires tableExemplaires;
	
	public CentrePanel3()
	{
		this.setBackground(Color.orange);
		this.setLayout(new BorderLayout());
		
		tableExemplaires = new TableExemplaires();
		this.add(tableExemplaires.getTableHeader(),BorderLayout.NORTH);
		this.add(tableExemplaires,BorderLayout.CENTER);

	}

	public static TableExemplaires getTableExemplaires()
	{
		return tableExemplaires;
	}

}
