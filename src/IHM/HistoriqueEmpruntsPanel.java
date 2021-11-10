package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class HistoriqueEmpruntsPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6990048144443207349L;
	private TitrePanel5 titrePanel5;
	private SousTitrePanel5 sousTitrePanel5;
	
	public HistoriqueEmpruntsPanel(HistoriqueEmpruntsDialog exemplairesDialog)
	{
		super();
		this.setLayout(new BorderLayout());
		
		this.titrePanel5 = new TitrePanel5();
		this.add(titrePanel5, BorderLayout.NORTH);
		
		this.sousTitrePanel5 = new SousTitrePanel5();
		this.add(sousTitrePanel5, BorderLayout.CENTER);
	}
}

