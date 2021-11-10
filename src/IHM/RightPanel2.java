package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class RightPanel2 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7868586244171296770L;
	private NorthPanel2 northPanel2;
	private static CentrePanel2 centrePanel2;

	
	@SuppressWarnings("static-access")
	public RightPanel2()
	{
		this.setLayout(new BorderLayout());

		this.setBackground(Color.RED);
		
		this.northPanel2 = new NorthPanel2();
		this.add(northPanel2, BorderLayout.NORTH);
		
		this.centrePanel2 = new CentrePanel2();
		this.add(centrePanel2, BorderLayout.CENTER);
	}


	
	
	
}