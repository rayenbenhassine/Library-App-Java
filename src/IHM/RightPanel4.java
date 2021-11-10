package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class RightPanel4 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5748800678322124863L;
	private static NorthPanel4 northPanel4;
	private static CentrePanel4 centrePanel4;

	
	@SuppressWarnings("static-access")
	public RightPanel4()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.RED);
		
		this.northPanel4 = new NorthPanel4();
		this.add(northPanel4, BorderLayout.NORTH);
		
		this.centrePanel4 = new CentrePanel4();
		this.add(centrePanel4, BorderLayout.CENTER);
	}


	public static NorthPanel4 getNorthPanel4() {
		return northPanel4;
	}

}
