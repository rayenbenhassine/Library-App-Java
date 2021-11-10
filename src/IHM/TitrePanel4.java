package IHM;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitrePanel4 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2982308979494307874L;
	private JLabel titre; 
	
	public TitrePanel4()
	{
		this.setLayout(new FlowLayout());
		this.titre = new JLabel("GESTION DES EMPRUNTS");
		titre.setFont(new Font("Segoe UI",Font.BOLD,35));
		titre.setForeground(Color.WHITE);
		this.setBackground(new Color(63,123,93));
		this.add(titre);
		
	}
}
