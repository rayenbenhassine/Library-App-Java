package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class SousTitrePanel5 extends JPanel
{
	private static final long serialVersionUID = -1937420418734191922L;
	
	private LeftPanel5 leftPanel5;
	private RightPanel5 rightPanel5;

	
	public SousTitrePanel5()
	{
		//this.setBackground(Color.orange);
		this.setLayout(new BorderLayout());
		
		this.leftPanel5 = new LeftPanel5();
		this.add(leftPanel5, BorderLayout.WEST);
		
		this.rightPanel5 = new RightPanel5();
		this.add(rightPanel5, BorderLayout.CENTER);

		
	}
	
}