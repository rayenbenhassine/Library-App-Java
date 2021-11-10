package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class RightPanel3 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8069878714250194133L;
	private static NorthPanel3 northPanel3;
	private static CentrePanel3 centrePanel3;

	
	@SuppressWarnings("static-access")
	public RightPanel3()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.RED);
		
		this.northPanel3 = new NorthPanel3();
		this.add(northPanel3, BorderLayout.NORTH);
		
		this.centrePanel3 = new CentrePanel3();
		this.add(centrePanel3, BorderLayout.CENTER);
	}


	public static NorthPanel3 getNorthPanel3() {
		return northPanel3;
	}

	
}
