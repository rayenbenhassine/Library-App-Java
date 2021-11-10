package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class SousTitrePanel2 extends JPanel
{
	private static final long serialVersionUID = -1937420418734191922L;
	
	private LeftPanel2 leftPanel2;
	private RightPanel2 rightPanel2;

	
	public SousTitrePanel2()
	{
		this.setLayout(new BorderLayout());
		
		this.leftPanel2 = new LeftPanel2();
		this.add(leftPanel2, BorderLayout.WEST);
		
		this.rightPanel2 = new RightPanel2();
		this.add(rightPanel2, BorderLayout.CENTER);

		
	}
	
}
