package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class RightPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 518436705221210264L;
	private NorthPanel northPanel;
	private static CentrePanel centrePanel;

	
	@SuppressWarnings({ "static-access" })
	public RightPanel()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);

		
		this.northPanel = new NorthPanel();
		this.add(northPanel, BorderLayout.NORTH);
		
		this.centrePanel = new CentrePanel();
		this.add(centrePanel, BorderLayout.CENTER);
	
		
	}


	public static CentrePanel getCentrePanel() {
		return centrePanel;
	}
	
	
	
}