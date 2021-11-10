package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class AbonnePanel extends JPanel
{

	private static final long serialVersionUID = 2960607343131922777L;
	private TitrePanel titrePanel;
	private SousTitrePanel sousTitrePanel ;
	
	public AbonnePanel()
	{
		super();
		this.setLayout(new BorderLayout());
		
		this.titrePanel = new TitrePanel();
		this.add(titrePanel, BorderLayout.NORTH);
	
		this.sousTitrePanel = new SousTitrePanel();
		this.add(sousTitrePanel, BorderLayout.CENTER);
		
		
		
	}
}
