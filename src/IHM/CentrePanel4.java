package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class CentrePanel4 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8481634207662175370L;
	private EmpruntsPanel empruntsPanel;
	private DisponiblesPanel disponiblesPanel;

	public CentrePanel4()
	{
		this.setLayout(new BorderLayout());
		
		this.empruntsPanel = new EmpruntsPanel();
		this.add(empruntsPanel, BorderLayout.CENTER);
	
		this.disponiblesPanel = new DisponiblesPanel();
		this.add(disponiblesPanel, BorderLayout.EAST);


		
	}
	
}
