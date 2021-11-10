package IHM;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitrePanel5 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6821819277849276768L;
	private JLabel titre; 
	
	public TitrePanel5()
	{
		this.setLayout(new FlowLayout());
		this.titre = new JLabel("HISTORIQUE DES EMPRUNTS");
		titre.setFont(new Font("Segoe UI",Font.BOLD,35));
		titre.setForeground(Color.WHITE);
		this.setBackground(new Color(63,123,93));
		this.add(titre);
		
	}
}
