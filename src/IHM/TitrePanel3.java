package IHM;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitrePanel3 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2802601345946460597L;
	private JLabel titre; 
	
	public TitrePanel3()
	{
		this.setLayout(new FlowLayout());
		this.titre = new JLabel("FICHE OEUVRE");
		titre.setFont(new Font("Segoe UI",Font.BOLD,35));
		this.setBackground(new Color(35,106,106));
		titre.setForeground(Color.WHITE);
		this.add(titre);
		
	}
}
