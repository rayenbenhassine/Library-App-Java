package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class CentrePanel2 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 110445391177649276L;
	private static TableLivres tableLivres;
	
	public CentrePanel2()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		tableLivres = new TableLivres();
		this.add(tableLivres.getTableHeader(),BorderLayout.NORTH);
		this.add(tableLivres,BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(tableLivres);
		this.add(scrollPane);
	}

	public static TableLivres getTableLivres()
	{
		return tableLivres;
	}


	

}

