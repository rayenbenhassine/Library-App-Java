package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ExemplairesPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7140001301711453581L;
	private TitrePanel3 titrePanel3;
	private SousTitrePanel3 sousTitrePanel3;
	
	public ExemplairesPanel(ExemplairesDialog exemplairesDialog)
	{
		super();
		this.setLayout(new BorderLayout());
		
		this.titrePanel3 = new TitrePanel3();
		this.add(titrePanel3, BorderLayout.NORTH);
		
		this.sousTitrePanel3 = new SousTitrePanel3();
		this.add(sousTitrePanel3, BorderLayout.CENTER);
	}
}
