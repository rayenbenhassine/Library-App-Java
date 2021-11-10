package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class SousTitrePanel3 extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8762075522400219453L;
	private LeftPanel3 leftPanel3;
	private RightPanel3 rightPanel3;

	
	public SousTitrePanel3()
	{
		this.setLayout(new BorderLayout());
		
		this.leftPanel3 = new LeftPanel3();
		this.add(leftPanel3, BorderLayout.WEST);
		
		this.rightPanel3 = new RightPanel3();
		this.add(rightPanel3, BorderLayout.CENTER);

		
	}
	
}
