package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class LivrePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7996068279242006042L;
	private TitrePanel2 titrePanel2;
	private SousTitrePanel2 sousTitrePanel2 ;
	
	public LivrePanel()
	{
		super();
		this.setLayout(new BorderLayout());
		
		this.titrePanel2 = new TitrePanel2();
		this.add(titrePanel2, BorderLayout.NORTH);
		
		this.sousTitrePanel2 = new SousTitrePanel2();
		this.add(sousTitrePanel2, BorderLayout.CENTER);

		
	}
}