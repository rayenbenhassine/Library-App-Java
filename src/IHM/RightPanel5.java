package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class RightPanel5 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1207607144748730959L;
	private static NorthPanel5 northPanel5;
	private static CentrePanel5 centrePanel5;

	
	@SuppressWarnings("static-access")
	public RightPanel5()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.RED);
		
		this.northPanel5 = new NorthPanel5();
		this.add(northPanel5, BorderLayout.NORTH);
		
		this.centrePanel5 = new CentrePanel5();
		this.add(centrePanel5, BorderLayout.CENTER);
	}


	public static NorthPanel5 getNorthPanel5() {
		return northPanel5;
	}

}