package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class SousTitrePanel extends JPanel
{
	private static final long serialVersionUID = -1937420418734191922L;
	
	private LeftPanel leftPanel;
	private RightPanel rightPanel;

	
	public SousTitrePanel()
	{		this.setBackground(Color.WHITE);

		//this.setBackground(Color.orange);
		this.setLayout(new BorderLayout());
		
		this.leftPanel = new LeftPanel();
		this.add(leftPanel, BorderLayout.WEST);
		
		this.rightPanel = new RightPanel();
		this.add(rightPanel, BorderLayout.CENTER);

		
	}
	
}
