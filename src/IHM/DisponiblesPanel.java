package IHM;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class DisponiblesPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3897683299504649315L;
	private static TableDisponibles tableDisponibles;

	public DisponiblesPanel()
	{
		this.setLayout(new BorderLayout());
		
		JPanel disponiblePanelLeft = new JPanel();
		disponiblePanelLeft.setBackground(new Color(36,72,54));

		this.add(disponiblePanelLeft, BorderLayout.WEST);
		
		JPanel disponiblePanelCentre = new JPanel();
		this.add(disponiblePanelCentre, BorderLayout.CENTER);
		
		disponiblePanelCentre.setLayout(new BorderLayout());
		disponiblePanelCentre.setBackground(Color.WHITE);
		tableDisponibles = new TableDisponibles();
		disponiblePanelCentre.add(tableDisponibles.getTableHeader(),BorderLayout.NORTH);
		disponiblePanelCentre.add(tableDisponibles,BorderLayout.CENTER);

		

	}
	
	public static TableDisponibles getTableDisponibles() 
	{
		return tableDisponibles;
	}
}
