package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class EmpruntPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2267568051060524249L;
	private TitrePanel4 titrePanel4;
	private SousTitrePanel4 sousTitrePanel4 ;
	
	public EmpruntPanel()
	{
		super();
		this.setLayout(new BorderLayout());
		
		this.titrePanel4 = new TitrePanel4();
		this.add(titrePanel4, BorderLayout.NORTH);
		
		this.sousTitrePanel4 = new SousTitrePanel4();
		this.add(sousTitrePanel4, BorderLayout.CENTER);

		
		
		
	}
}
