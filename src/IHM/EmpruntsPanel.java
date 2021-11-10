package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class EmpruntsPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6131624899006040987L;
	private static TableEmprunts tableEmpurunts;

	public EmpruntsPanel()
	{
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		tableEmpurunts = new TableEmprunts();
		this.add(tableEmpurunts.getTableHeader(),BorderLayout.NORTH);
		this.add(tableEmpurunts,BorderLayout.CENTER);

	}
	
	public static TableEmprunts getTableEmpurunts() 
	{
		return tableEmpurunts;
	}
}
