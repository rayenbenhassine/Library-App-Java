package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class SousTitrePanel4 extends JPanel
{
	private static final long serialVersionUID = -1937420418734191922L;
	
	private LeftPanel4 leftPanel4;
	private RightPanel4 rightPanel4;

	
	public SousTitrePanel4()
	{
		this.setLayout(new BorderLayout());
		
		this.leftPanel4 = new LeftPanel4();
		this.add(leftPanel4, BorderLayout.WEST);
		
		this.rightPanel4 = new RightPanel4();
		this.add(rightPanel4, BorderLayout.CENTER);

		
	}
	
}